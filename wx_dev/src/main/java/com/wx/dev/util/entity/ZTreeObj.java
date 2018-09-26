package com.wx.dev.util.entity;

import java.util.List;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年2月20日下午12:48:48
 * @author: 周志刚
 * @ClassName: ZTreeObj
 * @Description: TODO
 */
public class ZTreeObj {

	private int id;
	private int pid;
	private String name;
	private List<ZTreeObj> children;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ZTreeObj> getChildren() {
		return children;
	}

	public void setChildren(List<ZTreeObj> children) {
		this.children = children;
	}

}
