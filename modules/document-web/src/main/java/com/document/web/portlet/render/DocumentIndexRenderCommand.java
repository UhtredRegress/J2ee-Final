package com.document.web.portlet.render;

import com.document.data.service.DocumentLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.document.data.viewmodel.DocumentIndexViewModel;
import com.document.web.constants.DocumentWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    property = {
	        "javax.portlet.name=" + DocumentWebPortletKeys.DOCUMENTWEB,
	        "mvc.command.name=/document/index"
	    },
	    service = MVCRenderCommand.class
	)
public class DocumentIndexRenderCommand implements MVCRenderCommand {
	  @Reference
	   private DocumentLocalService _documentLocalService;
	  
	  @Override
	  public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	        
		  int cur = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, 1);
		  int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 5);
	      int start = (cur - 1) * delta;  
	      int end = start + delta;
	
	        
	      List<DocumentIndexViewModel> documents = new ArrayList<DocumentIndexViewModel>();
		try {
			documents = _documentLocalService.getDocumentViewModel(start, end);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	        
	      int total = _documentLocalService.getDocumentsCount();
		        
	      renderRequest.setAttribute("documentList", documents);	        
	      renderRequest.setAttribute("totalCount", total);
	        
	      PortletURL iteratorURL = renderResponse.createRenderURL();	        
	      iteratorURL.setParameter("mvcRenderCommandName", "/document/index");
	      renderRequest.setAttribute("iteratorURL", iteratorURL);	
	        
	      PortletURL editURL = renderResponse.createRenderURL();	        
	      editURL.setParameter("mvcRenderCommandName", "/document/edit");	        
	      renderRequest.setAttribute("editURL", editURL.toString());
	
	      PortletURL deleteURL = renderResponse.createActionURL();
	      deleteURL.setParameter(ActionRequest.ACTION_NAME, "/document/delete");
	      renderRequest.setAttribute("deleteActionURL", deleteURL.toString());
	
	        
	      return "/document/index.jsp";
	  }
}

	
