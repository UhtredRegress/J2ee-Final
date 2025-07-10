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
 * The table class for the &quot;DocumentData_Tag&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Tag
 * @generated
 */
public class TagTable extends BaseTable<TagTable> {

	public static final TagTable INSTANCE = new TagTable();

	public final Column<TagTable, Long> tagId = createColumn(
		"tagId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TagTable, String> tagName = createColumn(
		"tagName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TagTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TagTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private TagTable() {
		super("DocumentData_Tag", TagTable::new);
	}

}