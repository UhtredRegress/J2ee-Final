package com.document.web.portlet.render;

import com.document.data.model.Tag;
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
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + DocumentWebPortletKeys.DOCUMENTWEB,
	        "mvc.command.name=/tag/edit"
	    },
	    service = MVCRenderCommand.class
	)
public class TagEditRenderCommand implements MVCRenderCommand{
	@Reference
	private TagLocalService _tagLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long tagId = ParamUtil.getLong(renderRequest, "tagId");
		try {
			Tag foundTag = _tagLocalService.getTag(tagId);
			renderRequest.setAttribute("tag", foundTag);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/tag/edit.jsp";
    }
}
