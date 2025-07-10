/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.service.persistence.test;

import com.document.data.exception.NoSuchTagException;
import com.document.data.model.Tag;
import com.document.data.service.TagLocalServiceUtil;
import com.document.data.service.persistence.TagPersistence;
import com.document.data.service.persistence.TagUtil;

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
public class TagPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.document.data.service"));

	@Before
	public void setUp() {
		_persistence = TagUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Tag> iterator = _tags.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tag tag = _persistence.create(pk);

		Assert.assertNotNull(tag);

		Assert.assertEquals(tag.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Tag newTag = addTag();

		_persistence.remove(newTag);

		Tag existingTag = _persistence.fetchByPrimaryKey(
			newTag.getPrimaryKey());

		Assert.assertNull(existingTag);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTag();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tag newTag = _persistence.create(pk);

		newTag.setTagName(RandomTestUtil.randomString());

		newTag.setCreateDate(RandomTestUtil.nextDate());

		newTag.setModifiedDate(RandomTestUtil.nextDate());

		_tags.add(_persistence.update(newTag));

		Tag existingTag = _persistence.findByPrimaryKey(newTag.getPrimaryKey());

		Assert.assertEquals(existingTag.getTagId(), newTag.getTagId());
		Assert.assertEquals(existingTag.getTagName(), newTag.getTagName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTag.getCreateDate()),
			Time.getShortTimestamp(newTag.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTag.getModifiedDate()),
			Time.getShortTimestamp(newTag.getModifiedDate()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Tag newTag = addTag();

		Tag existingTag = _persistence.findByPrimaryKey(newTag.getPrimaryKey());

		Assert.assertEquals(existingTag, newTag);
	}

	@Test(expected = NoSuchTagException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Tag> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"DocumentData_Tag", "tagId", true, "tagName", true, "createDate",
			true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Tag newTag = addTag();

		Tag existingTag = _persistence.fetchByPrimaryKey(
			newTag.getPrimaryKey());

		Assert.assertEquals(existingTag, newTag);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tag missingTag = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTag);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Tag newTag1 = addTag();
		Tag newTag2 = addTag();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTag1.getPrimaryKey());
		primaryKeys.add(newTag2.getPrimaryKey());

		Map<Serializable, Tag> tags = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, tags.size());
		Assert.assertEquals(newTag1, tags.get(newTag1.getPrimaryKey()));
		Assert.assertEquals(newTag2, tags.get(newTag2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Tag> tags = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(tags.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Tag newTag = addTag();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTag.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Tag> tags = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, tags.size());
		Assert.assertEquals(newTag, tags.get(newTag.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Tag> tags = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(tags.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Tag newTag = addTag();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTag.getPrimaryKey());

		Map<Serializable, Tag> tags = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, tags.size());
		Assert.assertEquals(newTag, tags.get(newTag.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TagLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Tag>() {

				@Override
				public void performAction(Tag tag) {
					Assert.assertNotNull(tag);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Tag newTag = addTag();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Tag.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("tagId", newTag.getTagId()));

		List<Tag> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Tag existingTag = result.get(0);

		Assert.assertEquals(existingTag, newTag);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Tag.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("tagId", RandomTestUtil.nextLong()));

		List<Tag> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Tag newTag = addTag();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Tag.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("tagId"));

		Object newTagId = newTag.getTagId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("tagId", new Object[] {newTagId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTagId = result.get(0);

		Assert.assertEquals(existingTagId, newTagId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Tag.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("tagId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"tagId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Tag addTag() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Tag tag = _persistence.create(pk);

		tag.setTagName(RandomTestUtil.randomString());

		tag.setCreateDate(RandomTestUtil.nextDate());

		tag.setModifiedDate(RandomTestUtil.nextDate());

		_tags.add(_persistence.update(tag));

		return tag;
	}

	private List<Tag> _tags = new ArrayList<Tag>();
	private TagPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}