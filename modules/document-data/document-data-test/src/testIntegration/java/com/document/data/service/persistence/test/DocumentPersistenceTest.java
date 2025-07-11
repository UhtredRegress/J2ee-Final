/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.service.persistence.test;

import com.document.data.exception.NoSuchDocumentException;
import com.document.data.model.Document;
import com.document.data.service.DocumentLocalServiceUtil;
import com.document.data.service.persistence.DocumentPersistence;
import com.document.data.service.persistence.DocumentUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class DocumentPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.document.data.service"));

	@Before
	public void setUp() {
		_persistence = DocumentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Document> iterator = _documents.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Document document = _persistence.create(pk);

		Assert.assertNotNull(document);

		Assert.assertEquals(document.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Document newDocument = addDocument();

		_persistence.remove(newDocument);

		Document existingDocument = _persistence.fetchByPrimaryKey(
			newDocument.getPrimaryKey());

		Assert.assertNull(existingDocument);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDocument();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Document newDocument = _persistence.create(pk);

		newDocument.setTagId(RandomTestUtil.nextLong());

		newDocument.setTitle(RandomTestUtil.randomString());

		newDocument.setAddress(RandomTestUtil.randomString());

		newDocument.setAuthor(RandomTestUtil.randomString());

		newDocument.setYearPublished(RandomTestUtil.nextLong());

		newDocument.setCreateDate(RandomTestUtil.nextDate());

		newDocument.setModifiedDate(RandomTestUtil.nextDate());

		_documents.add(_persistence.update(newDocument));

		Document existingDocument = _persistence.findByPrimaryKey(
			newDocument.getPrimaryKey());

		Assert.assertEquals(
			existingDocument.getDocumentId(), newDocument.getDocumentId());
		Assert.assertEquals(
			existingDocument.getTagId(), newDocument.getTagId());
		Assert.assertEquals(
			existingDocument.getTitle(), newDocument.getTitle());
		Assert.assertEquals(
			existingDocument.getAddress(), newDocument.getAddress());
		Assert.assertEquals(
			existingDocument.getAuthor(), newDocument.getAuthor());
		Assert.assertEquals(
			existingDocument.getYearPublished(),
			newDocument.getYearPublished());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDocument.getCreateDate()),
			Time.getShortTimestamp(newDocument.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDocument.getModifiedDate()),
			Time.getShortTimestamp(newDocument.getModifiedDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Document newDocument = addDocument();

		Document existingDocument = _persistence.findByPrimaryKey(
			newDocument.getPrimaryKey());

		Assert.assertEquals(existingDocument, newDocument);
	}

	@Test(expected = NoSuchDocumentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Document> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DocumentData_Document", "documentId", true, "tagId", true, "title",
			true, "address", true, "author", true, "yearPublished", true,
			"createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Document newDocument = addDocument();

		Document existingDocument = _persistence.fetchByPrimaryKey(
			newDocument.getPrimaryKey());

		Assert.assertEquals(existingDocument, newDocument);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Document missingDocument = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDocument);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Document newDocument1 = addDocument();
		Document newDocument2 = addDocument();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocument1.getPrimaryKey());
		primaryKeys.add(newDocument2.getPrimaryKey());

		Map<Serializable, Document> documents = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, documents.size());
		Assert.assertEquals(
			newDocument1, documents.get(newDocument1.getPrimaryKey()));
		Assert.assertEquals(
			newDocument2, documents.get(newDocument2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Document> documents = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(documents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Document newDocument = addDocument();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocument.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Document> documents = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, documents.size());
		Assert.assertEquals(
			newDocument, documents.get(newDocument.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Document> documents = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(documents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Document newDocument = addDocument();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDocument.getPrimaryKey());

		Map<Serializable, Document> documents = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, documents.size());
		Assert.assertEquals(
			newDocument, documents.get(newDocument.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DocumentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Document>() {

				@Override
				public void performAction(Document document) {
					Assert.assertNotNull(document);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Document newDocument = addDocument();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Document.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"documentId", newDocument.getDocumentId()));

		List<Document> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Document existingDocument = result.get(0);

		Assert.assertEquals(existingDocument, newDocument);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Document.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"documentId", RandomTestUtil.nextLong()));

		List<Document> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Document newDocument = addDocument();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Document.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("documentId"));

		Object newDocumentId = newDocument.getDocumentId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"documentId", new Object[] {newDocumentId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDocumentId = result.get(0);

		Assert.assertEquals(existingDocumentId, newDocumentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Document.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("documentId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"documentId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Document addDocument() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Document document = _persistence.create(pk);

		document.setTagId(RandomTestUtil.nextLong());

		document.setTitle(RandomTestUtil.randomString());

		document.setAddress(RandomTestUtil.randomString());

		document.setAuthor(RandomTestUtil.randomString());

		document.setYearPublished(RandomTestUtil.nextLong());

		document.setCreateDate(RandomTestUtil.nextDate());

		document.setModifiedDate(RandomTestUtil.nextDate());

		_documents.add(_persistence.update(document));

		return document;
	}

	private List<Document> _documents = new ArrayList<Document>();
	private DocumentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}