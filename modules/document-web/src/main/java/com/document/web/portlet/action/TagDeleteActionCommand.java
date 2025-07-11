package com.document.web.portlet.action;

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
	        "mvc.command.name=/tag/delete"
	    },
	    service = MVCActionCommand.class
	)
public class TagDeleteActionCommand implements MVCActionCommand{
	@Reference
	private TagLocalService _tagLocalService;
	
	@Override
	 public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
	            throws PortletException {
	     long tagId = ParamUtil.getLong(actionRequest, "tagId");

		 try {
			 _tagLocalService.deleteTag(tagId); 
		 } catch (Exception e)
		 {
			 e.printStackTrace();
		 }
	     actionResponse.setRenderParameter("mvcRenderCommandName", "/tag/index");
		 return true;
	 }

}
