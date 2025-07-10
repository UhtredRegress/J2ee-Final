/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TagService}.
 *
 * @author Brian Wing Shun Chan
 * @see TagService
 * @generated
 */
public class TagServiceWrapper
	implements ServiceWrapper<TagService>, TagService {

	public TagServiceWrapper() {
		this(null);
	}

	public TagServiceWrapper(TagService tagService) {
		_tagService = tagService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tagService.getOSGiServiceIdentifier();
	}

	@Override
	public TagService getWrappedService() {
		return _tagService;
	}

	@Override
	public void setWrappedService(TagService tagService) {
		_tagService = tagService;
	}

	private TagService _tagService;

}