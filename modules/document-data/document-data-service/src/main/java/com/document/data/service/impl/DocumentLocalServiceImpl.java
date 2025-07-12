/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.service.impl;

import com.document.data.model.Document;
import com.document.data.model.Tag;
import com.document.data.service.TagLocalService;
import com.document.data.service.base.DocumentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.document.data.viewmodel.DocumentIndexViewModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.document.data.model.Document",
	service = AopService.class
)
public class DocumentLocalServiceImpl extends DocumentLocalServiceBaseImpl {
	@Reference
	private TagLocalService _tagLocalService;
	
	private String fileHandle(File file, String title, Date now) throws IOException {
		try {
	        if (file == null || !file.exists()) {
	            throw new IllegalArgumentException("Source file is null or doesn't exist: " + file);
	        }
	        String basePath = new File("").getAbsolutePath(); 
	        String uploadDir = basePath + File.separator + "upload";

	        File targetDir = new File(uploadDir);

	        if (!targetDir.exists()) {
	            targetDir.mkdirs();
	        }
	        
	        String originalFileName = file.getName();
	        String extension = "";

	        int i = originalFileName.lastIndexOf('.');
	        if (i > 0) {
	            extension = originalFileName.substring(i);
	        }

	 

	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	        String formattedDate = formatter.format(now);
	        String safeTitle = title.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
	        String fileName = safeTitle + "_" + formattedDate + extension;

	        File destinationFile = new File(targetDir, fileName);

	        System.out.println("Uploading to: " + destinationFile.getAbsolutePath());

	        Files.copy(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

	        System.out.println("File successfully copied.");
	        return "upload/" + fileName;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public Document addDocument(String title,File file, long tagId, String author, long yearPublished) throws IOException {
		long documentId = counterLocalService.increment(Document.class.getName());
		Document doc = super.createDocument(documentId);
		doc.setTitle(title);
		doc.setAuthor(author);
		doc.setTagId(tagId);
		doc.setYearPublished(yearPublished);
		Date now = new Date();
		doc.setCreateDate(now);
		doc.setModifiedDate(now);
		String address = fileHandle(file, title, now);
		doc.setAddress(address);
		return super.addDocument(doc);
	}
	
	private boolean deleteFile(String filePath) {
		  File file = new File(filePath);
		  return file.delete();
	}
	
	public Document editDocument(long documentId, String title, File file, long tagId, String author, long yearPublished) throws PortalException, IOException {
		Document doc = super.getDocument(documentId);
		doc.setTitle(title);
		doc.setAuthor(author);
		doc.setTagId(tagId);
		doc.setYearPublished(yearPublished);
		Date now = new Date();
		doc.setModifiedDate(now);
		
		if (file != null && file.exists()) {
			if (deleteFile(doc.getAddress()) == false) {
				throw new PortalException();
			}
			String address = fileHandle(file, title, now);
			doc.setAddress(address);
		} 
		

		return super.updateDocument(doc);
	}
	
	public List<DocumentIndexViewModel> getDocumentViewModel(int start, int end) throws PortalException {
		List<Document> listDoc = super.getDocuments(start, end);
		HashMap<Long, String> tagDiction = new HashMap<Long, String>();
		List<DocumentIndexViewModel> result = new ArrayList<DocumentIndexViewModel>();
		
		for (Document doc: listDoc) {
			DocumentIndexViewModel docView = new DocumentIndexViewModel();
			docView.setDocumentId(doc.getDocumentId());
			docView.setTagId(doc.getTagId());
			docView.setAddress(doc.getAddress());
			
			if (!tagDiction.containsKey(doc.getTagId())) {
				String tagName = _tagLocalService.getTag(docView.getTagId()).getTagName();
				tagDiction.put(docView.getTagId(), tagName);
			}
			docView.setTagName(tagDiction.get(docView.getTagId()));
			docView.setAuthor(doc.getAuthor());
			docView.setCreateDate(doc.getCreateDate());
			docView.setModifiedDate(doc.getModifiedDate());
			docView.setYearPublished(doc.getYearPublished());
			docView.setTitle(doc.getTitle());
			result.add(docView);
		}
		return result;
	}
	
}