package com.document.web.portlet.action;

import com.document.data.service.DocumentLocalService;
import com.document.data.service.TagLocalService;
import com.document.web.constants.DocumentWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + DocumentWebPortletKeys.DOCUMENTWEB,
	        "mvc.command.name=/document/delete"
	    },
	    service = MVCActionCommand.class
	)
public class DocumentDeleteActionCommand implements MVCActionCommand{
	@Reference
	private DocumentLocalService _documentLocalService;
	
	@Override
	 public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
	            throws PortletException {
	     long documentId = ParamUtil.getLong(actionRequest, "documentId");

		 try {
			 _documentLocalService.deleteDocument(documentId); 
		 } catch (Exception e)
		 {
			 e.printStackTrace();
		 }
	     actionResponse.setRenderParameter("mvcRenderCommandName", "/document/index");
		 return true;
	 }

}
