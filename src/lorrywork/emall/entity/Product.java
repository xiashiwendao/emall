/***********************************************************************
 * Module:  Good.java
 * Author:  Lorry
 * Purpose: Defines the Class Good
 ***********************************************************************/
package lorrywork.emall.entity;

/**
 * 商品信息
 * 
 * @author Lorry
 *
 */
public class Product {
	/**
	 * @pdOid d3668422-b2a9-479a-9be2-1ea306114c9f
	 */
	private long id;
	/**
	 * @pdOid 177a5bae-cdb9-4b97-90f5-38ea76d806cc
	 */
	private java.lang.String name;
	/**
	 * @pdOid c467ed70-8a65-4423-ba2c-37f570d96d70
	 */
	private int categoryId;
	/**
	 * @pdOid 1d14353e-8a34-422f-92be-9d32a9268ed1
	 */
	private java.lang.String picUrl;
	/**
	 * @pdOid 437d5d6d-5e26-487e-a192-a38aefa2ba3b
	 */
	private java.util.Date createDate;
	/**
	 * @pdOid 3e43ba31-7f2e-47ff-9c45-5ec5d6494a8c
	 */
	private int createUserId;
	/**
	 * @pdOid 5b21c5f3-b0e7-4b7a-bf8c-ad51adc860fa
	 */
	private java.util.Date updateDate;
	/**
	 * @pdOid 2930241d-3b43-4636-9c88-790d0e9e680c
	 */
	private int updateUserId;

	/**
	 * 说明
	 */
	private String introduction;

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * 价格
	 */
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public java.lang.String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(java.lang.String picUrl) {
		this.picUrl = picUrl;
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