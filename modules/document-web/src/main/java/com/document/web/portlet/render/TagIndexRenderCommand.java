package com.document.web.portlet.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.document.web.constants.DocumentWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.document.data.model.Tag;
import com.document.data.service.TagLocalService;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + DocumentWebPortletKeys.DOCUMENTWEB,
	        "mvc.command.name=/tag/index"
	    },
	    service = MVCRenderCommand.class
	)
public class TagIndexRenderCommand implements MVCRenderCommand{
	@Reference
	private TagLocalService _tagLocalService;
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        List<Tag> tagList = _tagLocalService.getAllTag();
        renderRequest.setAttribute("tagList", tagList);
		return "/tag/index.jsp";
    }
}
