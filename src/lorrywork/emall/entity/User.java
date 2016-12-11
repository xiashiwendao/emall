/***********************************************************************
 * Module:  User.java
 * Author:  Lorry
 * Purpose: Defines the Class User
 ***********************************************************************/
package lorrywork.emall.entity;

import java.util.*;

public class User {
	/** @pdOid 2ad2455a-e6ba-4d43-9877-812fe2d7510a */
	private long id;
	/** @pdOid dd0062c5-c8cc-4b77-ada9-d99f624496a4 */
	private java.lang.String userName;
	/** @pdOid 1a36cfc8-f9e3-4540-8cdb-6e859ba06506 */
	private String password;
	/** @pdOid d195a3d4-4540-4528-b6d7-ae3649a4400b */
	private java.util.Date createDate;
	/** @pdOid ae9f32e6-05b9-4928-b3a3-89cb7b7a1fdd */
	private int createUserId;
	/** @pdOid 789815b6-dd50-497e-8003-b1a6d3277df6 */
	private java.util.Date updateDate;
	/** @pdOid 4898314c-4d0c-418c-9e47-f5a8226f3437 */
	private int updateUserId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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