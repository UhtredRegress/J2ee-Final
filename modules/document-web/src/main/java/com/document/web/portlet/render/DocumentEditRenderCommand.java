package com.document.web.portlet.render;

import com.document.data.model.Document;
import com.document.data.model.Tag;
import com.document.data.service.DocumentLocalService;
import com.document.data.service.TagLocalService;
import com.document.web.constants.DocumentWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    property = {
	        "javax.portlet.name=" + DocumentWebPortletKeys.DOCUMENTWEB,
	        "mvc.command.name=/document/edit"
	    },
	    service = MVCRenderCommand.class
	)
	public class DocumentEditRenderCommand implements MVCRenderCommand {

	    @Reference
	    private TagLocalService _tagLocalService;
	    
	    @Reference
	    private DocumentLocalService _documentLocalService;

	    @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	        
	    	long documentId = ParamUtil.getLong(renderRequest, "documentId");
	    	
	    	try {
				Document doc = _documentLocalService.getDocument(documentId);
				List<Tag> tags = _tagLocalService.getAllTag();
	
		        renderRequest.setAttribute("tagList", tags);
		        renderRequest.setAttribute("document", doc);
	    	} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	

	        return "/document/edit.jsp";
	    }
	}


