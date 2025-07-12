package com.document.web.portlet.action;

import com.document.data.service.DocumentLocalService;
import com.document.web.constants.DocumentWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + DocumentWebPortletKeys.DOCUMENTWEB,
	        "mvc.command.name=/document/edit"
	    },
	    service = MVCActionCommand.class
	)
public class DocumentEditActionCommand implements MVCActionCommand {
 
	@Reference 
	private DocumentLocalService _documentLocalService;

 
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		long documentId = ParamUtil.getLong(actionRequest, "documentId");
		String title = ParamUtil.getString(actionRequest, "title");
		String author = ParamUtil.getString(actionRequest, "author");
		long yearPublished = ParamUtil.getLong(actionRequest, "yearPublished");
		long tagId = ParamUtil.getLong(actionRequest, "tagId");
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		 
		File uploadedFile = uploadRequest.getFile("documentFile");
		
		try {
		_documentLocalService.editDocument(documentId , title, uploadedFile, tagId, author, yearPublished);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		actionResponse.setRenderParameter("mvcRenderCommandName", "/document/index");
		return true;
	}
}
