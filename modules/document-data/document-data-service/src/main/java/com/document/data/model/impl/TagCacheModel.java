/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.model.impl;

import com.document.data.model.Tag;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tag in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TagCacheModel implements CacheModel<Tag>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TagCacheModel)) {
			return false;
		}

		TagCacheModel tagCacheModel = (TagCacheModel)object;

		if (tagId == tagCacheModel.tagId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tagId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{tagId=");
		sb.append(tagId);
		sb.append(", tagName=");
		sb.append(tagName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tag toEntityModel() {
		TagImpl tagImpl = new TagImpl();

		tagImpl.setTagId(tagId);

		if (tagName == null) {
			tagImpl.setTagName("");
		}
		else {
			tagImpl.setTagName(tagName);
		}

		if (createDate == Long.MIN_VALUE) {
			tagImpl.setCreateDate(null);
		}
		else {
			tagImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tagImpl.setModifiedDate(null);
		}
		else {
			tagImpl.setModifiedDate(new Date(modifiedDate));
		}

		tagImpl.resetOriginalValues();

		return tagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tagId = objectInput.readLong();
		tagName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tagId);

		if (tagName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tagName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long tagId;
	public String tagName;
	public long createDate;
	public long modifiedDate;

}