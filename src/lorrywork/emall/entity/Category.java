/***********************************************************************
 * Module:  Category.java
 * Author:  Lorry
 * Purpose: Defines the Class Category
 ***********************************************************************/
package lorrywork.emall.entity;

/** @pdOid f3ddddf9-f394-4f24-997d-bb200985d9b5 */
public class Category {
	/** @pdOid e754c245-cc63-46dd-8b79-d82f93b9d52f */
	private long id;
	/** @pdOid e0ec3697-ac9a-42ef-aaca-879e876757df */
	private java.lang.String name;
	/** @pdOid d64a8560-b181-4748-b2a7-745d2a9b2d75 */
	private int level;
	/** @pdOid 6f2fe825-dd67-4864-8496-2439ef26c4df */
	private int parentId;
	/** @pdOid ce5f58a3-0a78-4f52-a3fa-25d1b2e6b260 */
	private java.util.Date createDate;
	/** @pdOid c55df4e3-14e6-49e5-a6c5-06d4517535d0 */
	private int createUserId;
	/** @pdOid 99b220a3-0d82-4a15-a421-a9fcb9c8110f */
	private java.util.Date updateDate;
	/** @pdOid acb30d16-6d05-4410-a0d9-433122d1f29f */
	private int updateUserId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}
}