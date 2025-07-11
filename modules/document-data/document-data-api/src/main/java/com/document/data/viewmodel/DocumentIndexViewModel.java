package com.document.data.viewmodel;

import java.util.Date;

public class DocumentIndexViewModel {
	private long documentId;
	private long tagId;
	private String tagName;
	private String address;
	private String author;
	private long yearPublished;
	private Date createDate;
	private Date modifiedDate;
	private String title;
	
	public DocumentIndexViewModel() {
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getDocumentId() {
	    return documentId;
	}

	public void setDocumentId(long documentId) {
	    this.documentId = documentId;
	}

	public long getTagId() {
	    return tagId;
	}

	public void setTagId(long tagId) {
	    this.tagId = tagId;
	}

	public String getTagName() {
	    return tagName;
	}

	public void setTagName(String tagName) {
	    this.tagName = tagName;
	}

	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}

	public String getAuthor() {
	    return author;
	}

	public void setAuthor(String author) {
	    this.author = author;
	}

	public long getYearPublished() {
	    return yearPublished;
	}

	public void setYearPublished(long yearPublished) {
	    this.yearPublished = yearPublished;
	}

	public Date getCreateDate() {
	    return createDate;
	}

	public void setCreateDate(Date createDate) {
	    this.createDate = createDate;
	}

	public Date getModifiedDate() {
	    return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
	    this.modifiedDate = modifiedDate;
	}

	
	
}
