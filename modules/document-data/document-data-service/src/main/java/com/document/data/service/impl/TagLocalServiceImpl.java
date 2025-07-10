/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.service.impl;

import com.document.data.exception.NoSuchTagException;
import com.document.data.model.Tag;
import com.document.data.service.base.TagLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.document.data.model.Tag",
	service = AopService.class
)
public class TagLocalServiceImpl extends TagLocalServiceBaseImpl {
	
	public Tag addTag(String tagName) {
	    long tagId = counterLocalService.increment(Tag.class.getName());

	    Tag tag = super.createTag(tagId);
	    tag.setTagId(tagId);
	    tag.setTagName(tagName);
	    Date now = new Date();
	    tag.setCreateDate(now);
	    tag.setModifiedDate(now);
	    return super.addTag(tag);
	}
	
	public Tag editTag(long tagId, String tagName) throws PortalException {
		Tag foundTag = super.getTag(tagId);
		foundTag.setTagName(tagName);
		foundTag.setModifiedDate(new Date()); 
		
		return super.updateTag(foundTag);
	}
	
	public List<Tag> getAllTag(){
		return tagPersistence.findAll();
	}
}