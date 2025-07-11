/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DocumentData_Document&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Document
 * @generated
 */
public class DocumentTable extends BaseTable<DocumentTable> {

	public static final DocumentTable INSTANCE = new DocumentTable();

	public final Column<DocumentTable, Long> documentId = createColumn(
		"documentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DocumentTable, Long> tagId = createColumn(
		"tagId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentTable, String> author = createColumn(
		"author", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentTable, Long> yearPublished = createColumn(
		"yearPublished", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DocumentTable() {
		super("DocumentData_Document", DocumentTable::new);
	}

}