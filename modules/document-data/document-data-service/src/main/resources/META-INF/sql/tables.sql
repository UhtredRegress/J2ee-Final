create table DocumentData_Document (
	documentId LONG not null primary key,
	tagId LONG,
	title VARCHAR(75) null,
	address VARCHAR(75) null,
	author VARCHAR(75) null,
	yearPublished LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table DocumentData_Tag (
	tagId LONG not null primary key,
	tagName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);