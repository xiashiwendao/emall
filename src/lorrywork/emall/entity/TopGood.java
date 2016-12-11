/***********************************************************************
 * Module:  TopGood.java
 * Author:  Lorry
 * Purpose: Defines the Class TopGood
 ***********************************************************************/
package lorrywork.emall.entity;

/**
 * top page goods
 * 
 * @pdOid 5abdb7be-50e3-4994-9a7d-9340272db2d0
 */
public class TopGood {
	/** @pdOid e1527c01-1a6a-49ba-a29b-08e0a13c6423 */
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.lang.String getGoodId() {
		return goodId;
	}

	public void setGoodId(java.lang.String goodId) {
		this.goodId = goodId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
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

	/** @pdOid ccf9da08-4d69-45ac-aa54-853cc8e7dc9b */
	private java.lang.String goodId;
	/** @pdOid 145c01e8-4754-418b-93ad-a4d9321ba105 */
	private int positionId;
	/** @pdOid 456ec3e6-dfc3-45e2-941d-907ada7139a2 */
	private java.util.Date createDate;
	/** @pdOid 7a5eaaca-6e0c-4758-b347-870bee6b4a74 */
	private int createUserId;
	/** @pdOid 18bafb16-fa01-41d1-84fb-840a542bb7a1 */
	private java.util.Date updateDate;
	/** @pdOid bfcc812e-8d35-4fd2-9944-16a317d82fdb */
	private int updateUserId;
}