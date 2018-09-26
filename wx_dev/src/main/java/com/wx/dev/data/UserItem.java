package com.wx.dev.data;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月5日下午3:34:01
 * @author: 周志刚
 * @ClassName: UserItem
 * @Description: TODO
 */
public class UserItem {
	private String userid;
	private String name;
	private String department;
	private String position;
	private String mobile;
	private String gender;
	private String email;
	private String weixinid;
	private String enable;
//	private String avatar_mediaid;
	private String extattr;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

//	public String getAvatar_mediaid() {
//		return avatar_mediaid;
//	}
//
//	public void setAvatar_mediaid(String avatar_mediaid) {
//		this.avatar_mediaid = avatar_mediaid;
//	}

	public String getExtattr() {
		return extattr;
	}

	public void setExtattr(String extattr) {
		this.extattr = extattr;
	}

}
