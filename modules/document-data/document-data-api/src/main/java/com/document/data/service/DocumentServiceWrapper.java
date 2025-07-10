/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DocumentService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentService
 * @generated
 */
public class DocumentServiceWrapper
	implements DocumentService, ServiceWrapper<DocumentService> {

	public DocumentServiceWrapper() {
		this(null);
	}

	public DocumentServiceWrapper(DocumentService documentService) {
		_documentService = documentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentService.getOSGiServiceIdentifier();
	}

	@Override
	public DocumentService getWrappedService() {
		return _documentService;
	}

	@Override
	public void setWrappedService(DocumentService documentService) {
		_documentService = documentService;
	}

	private DocumentService _documentService;

}