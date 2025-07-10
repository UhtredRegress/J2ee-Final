/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tag}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Tag
 * @generated
 */
public class TagWrapper
	extends BaseModelWrapper<Tag> implements ModelWrapper<Tag>, Tag {

	public TagWrapper(Tag tag) {
		super(tag);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tagId", getTagId());
		attributes.put("tagName", getTagName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		String tagName = (String)attributes.get("tagName");

		if (tagName != null) {
			setTagName(tagName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Tag cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this tag.
	 *
	 * @return the create date of this tag
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this tag.
	 *
	 * @return the modified date of this tag
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this tag.
	 *
	 * @return the primary key of this tag
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tag ID of this tag.
	 *
	 * @return the tag ID of this tag
	 */
	@Override
	public long getTagId() {
		return model.getTagId();
	}

	/**
	 * Returns the tag name of this tag.
	 *
	 * @return the tag name of this tag
	 */
	@Override
	public String getTagName() {
		return model.getTagName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this tag.
	 *
	 * @param createDate the create date of this tag
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this tag.
	 *
	 * @param modifiedDate the modified date of this tag
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this tag.
	 *
	 * @param primaryKey the primary key of this tag
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tag ID of this tag.
	 *
	 * @param tagId the tag ID of this tag
	 */
	@Override
	public void setTagId(long tagId) {
		model.setTagId(tagId);
	}

	/**
	 * Sets the tag name of this tag.
	 *
	 * @param tagName the tag name of this tag
	 */
	@Override
	public void setTagName(String tagName) {
		model.setTagName(tagName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TagWrapper wrap(Tag tag) {
		return new TagWrapper(tag);
	}

}