/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.model.impl;

import com.document.data.model.Document;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentCacheModel
	implements CacheModel<Document>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentCacheModel)) {
			return false;
		}

		DocumentCacheModel documentCacheModel = (DocumentCacheModel)object;

		if (documentId == documentCacheModel.documentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, documentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{documentId=");
		sb.append(documentId);
		sb.append(", tagId=");
		sb.append(tagId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", author=");
		sb.append(author);
		sb.append(", yearPublished=");
		sb.append(yearPublished);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(documentId);
		documentImpl.setTagId(tagId);

		if (address == null) {
			documentImpl.setAddress("");
		}
		else {
			documentImpl.setAddress(address);
		}

		if (author == null) {
			documentImpl.setAuthor("");
		}
		else {
			documentImpl.setAuthor(author);
		}

		documentImpl.setYearPublished(yearPublished);

		if (createDate == Long.MIN_VALUE) {
			documentImpl.setCreateDate(null);
		}
		else {
			documentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentImpl.setModifiedDate(null);
		}
		else {
			documentImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();

		tagId = objectInput.readLong();
		address = objectInput.readUTF();
		author = objectInput.readUTF();

		yearPublished = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(documentId);

		objectOutput.writeLong(tagId);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeLong(yearPublished);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long documentId;
	public long tagId;
	public String address;
	public String author;
	public long yearPublished;
	public long createDate;
	public long modifiedDate;

}