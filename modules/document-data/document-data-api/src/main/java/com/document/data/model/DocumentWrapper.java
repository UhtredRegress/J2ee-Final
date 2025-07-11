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
 * This class is a wrapper for {@link Document}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Document
 * @generated
 */
public class DocumentWrapper
	extends BaseModelWrapper<Document>
	implements Document, ModelWrapper<Document> {

	public DocumentWrapper(Document document) {
		super(document);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("tagId", getTagId());
		attributes.put("title", getTitle());
		attributes.put("address", getAddress());
		attributes.put("author", getAuthor());
		attributes.put("yearPublished", getYearPublished());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Long tagId = (Long)attributes.get("tagId");

		if (tagId != null) {
			setTagId(tagId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Long yearPublished = (Long)attributes.get("yearPublished");

		if (yearPublished != null) {
			setYearPublished(yearPublished);
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
	public Document cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this document.
	 *
	 * @return the address of this document
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the author of this document.
	 *
	 * @return the author of this document
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the create date of this document.
	 *
	 * @return the create date of this document
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the document ID of this document.
	 *
	 * @return the document ID of this document
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the modified date of this document.
	 *
	 * @return the modified date of this document
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this document.
	 *
	 * @return the primary key of this document
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tag ID of this document.
	 *
	 * @return the tag ID of this document
	 */
	@Override
	public long getTagId() {
		return model.getTagId();
	}

	/**
	 * Returns the title of this document.
	 *
	 * @return the title of this document
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the year published of this document.
	 *
	 * @return the year published of this document
	 */
	@Override
	public long getYearPublished() {
		return model.getYearPublished();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this document.
	 *
	 * @param address the address of this document
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the author of this document.
	 *
	 * @param author the author of this document
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	/**
	 * Sets the create date of this document.
	 *
	 * @param createDate the create date of this document
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the document ID of this document.
	 *
	 * @param documentId the document ID of this document
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the modified date of this document.
	 *
	 * @param modifiedDate the modified date of this document
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this document.
	 *
	 * @param primaryKey the primary key of this document
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tag ID of this document.
	 *
	 * @param tagId the tag ID of this document
	 */
	@Override
	public void setTagId(long tagId) {
		model.setTagId(tagId);
	}

	/**
	 * Sets the title of this document.
	 *
	 * @param title the title of this document
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the year published of this document.
	 *
	 * @param yearPublished the year published of this document
	 */
	@Override
	public void setYearPublished(long yearPublished) {
		model.setYearPublished(yearPublished);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DocumentWrapper wrap(Document document) {
		return new DocumentWrapper(document);
	}

}