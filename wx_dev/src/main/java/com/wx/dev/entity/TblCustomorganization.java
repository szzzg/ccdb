package com.wx.dev.entity;

import java.util.List;

public class TblCustomorganization {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tbl_customorganization.id
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tbl_customorganization.corpId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	private String corpid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tbl_customorganization.orgId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	private Integer orgid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tbl_customorganization.name
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tbl_customorganization.parentId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	private Integer parentid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column tbl_customorganization.order_
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	private Integer order;
	
	
	private List<TblCustomorganization> listOrgs;
	

	public List<TblCustomorganization> getListOrgs() {
		return listOrgs;
	}

	public void setListOrgs(List<TblCustomorganization> listOrgs) {
		this.listOrgs = listOrgs;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tbl_customorganization.id
	 * @return  the value of tbl_customorganization.id
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tbl_customorganization.id
	 * @param id  the value for tbl_customorganization.id
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tbl_customorganization.corpId
	 * @return  the value of tbl_customorganization.corpId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public String getCorpid() {
		return corpid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tbl_customorganization.corpId
	 * @param corpid  the value for tbl_customorganization.corpId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tbl_customorganization.orgId
	 * @return  the value of tbl_customorganization.orgId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public Integer getOrgid() {
		return orgid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tbl_customorganization.orgId
	 * @param orgid  the value for tbl_customorganization.orgId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tbl_customorganization.name
	 * @return  the value of tbl_customorganization.name
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tbl_customorganization.name
	 * @param name  the value for tbl_customorganization.name
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tbl_customorganization.parentId
	 * @return  the value of tbl_customorganization.parentId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tbl_customorganization.parentId
	 * @param parentid  the value for tbl_customorganization.parentId
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column tbl_customorganization.order_
	 * @return  the value of tbl_customorganization.order_
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column tbl_customorganization.order_
	 * @param order  the value for tbl_customorganization.order_
	 * @mbggenerated  Fri Dec 02 15:12:44 CST 2016
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
}