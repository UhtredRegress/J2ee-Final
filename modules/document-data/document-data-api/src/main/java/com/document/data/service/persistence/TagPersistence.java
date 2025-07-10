/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.document.data.service.persistence;

import com.document.data.exception.NoSuchTagException;
import com.document.data.model.Tag;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TagUtil
 * @generated
 */
@ProviderType
public interface TagPersistence extends BasePersistence<Tag> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TagUtil} to access the tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the tag in the entity cache if it is enabled.
	 *
	 * @param tag the tag
	 */
	public void cacheResult(Tag tag);

	/**
	 * Caches the tags in the entity cache if it is enabled.
	 *
	 * @param tags the tags
	 */
	public void cacheResult(java.util.List<Tag> tags);

	/**
	 * Creates a new tag with the primary key. Does not add the tag to the database.
	 *
	 * @param tagId the primary key for the new tag
	 * @return the new tag
	 */
	public Tag create(long tagId);

	/**
	 * Removes the tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag that was removed
	 * @throws NoSuchTagException if a tag with the primary key could not be found
	 */
	public Tag remove(long tagId) throws NoSuchTagException;

	public Tag updateImpl(Tag tag);

	/**
	 * Returns the tag with the primary key or throws a <code>NoSuchTagException</code> if it could not be found.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag
	 * @throws NoSuchTagException if a tag with the primary key could not be found
	 */
	public Tag findByPrimaryKey(long tagId) throws NoSuchTagException;

	/**
	 * Returns the tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagId the primary key of the tag
	 * @return the tag, or <code>null</code> if a tag with the primary key could not be found
	 */
	public Tag fetchByPrimaryKey(long tagId);

	/**
	 * Returns all the tags.
	 *
	 * @return the tags
	 */
	public java.util.List<Tag> findAll();

	/**
	 * Returns a range of all the tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @return the range of tags
	 */
	public java.util.List<Tag> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tags
	 */
	public java.util.List<Tag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag>
			orderByComparator);

	/**
	 * Returns an ordered range of all the tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tags
	 * @param end the upper bound of the range of tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tags
	 */
	public java.util.List<Tag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tag> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the tags from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of tags.
	 *
	 * @return the number of tags
	 */
	public int countAll();

}