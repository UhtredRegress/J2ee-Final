package com.document.web.portlet.render;

import com.document.data.model.Tag;
import com.document.data.service.TagLocalService;
import com.document.web.constants.DocumentWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    property = {
	        "javax.portlet.name="+ DocumentWebPortletKeys.DOCUMENTWEB,
	        "mvc.command.name=/document/create"
	    },
	    service = MVCRenderCommand.class
	)
	public class DocumentCreateRenderCommand implements MVCRenderCommand {

	    @Reference
	    private TagLocalService _tagLocalService;

	    @Override
	    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
	        List<Tag> tags = _tagLocalService.getAllTag();

	        renderRequest.setAttribute("tagList", tags);

	        return "/document/create.jsp";
	    }
	}


