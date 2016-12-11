/***********************************************************************
 * Module:  ViewHistory.java
 * Author:  Lorry
 * Purpose: Defines the Class ViewHistory
 ***********************************************************************/
package lorrywork.emall.entity;

import java.util.*;

/** @pdOid 7ffba5e7-1d91-4263-b9ba-a3d93c41ebb0 */
public class ViewHistory {
	/** @pdOid b8d18fc3-6a52-4b6f-8d75-e4d9f6a8c425 */
	private long id;
	/** @pdOid 4802f044-a9a2-4c5b-a2c0-c7660720b673 */
	private long userId;
	/** @pdOid 68370095-215b-41ea-b627-0b9c276dd775 */
	private long goodId;
	/**
	 * the view times
	 * 
	 * @pdOid 67f99494-5a68-4269-9c6f-4a896e5d5d76
	 */
	private int time;
	/** @pdOid 04c7289c-e0df-47ea-9618-1e69b2c40c3b */
	private java.util.Date createDate;
	/** @pdOid 87224cb9-12a1-44bc-bb3e-1d3319718b60 */
	private int createUserId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGoodId() {
		return goodId;
	}

	public void setGoodId(long goodId) {
		this.goodId = goodId;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
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
}