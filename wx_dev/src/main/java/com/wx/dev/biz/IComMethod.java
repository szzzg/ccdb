package com.wx.dev.biz;

import java.sql.SQLException;
import java.util.List;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月21日下午4:46:57
 * @author: 周志刚
 * @ClassName: IComMethod
 * @Description: TODO
 */
public interface IComMethod<T> {

	/**
	 * 动态保存
	 * 
	 * @param t
	 * @throws SQLException
	 */
	void saveSelective(T t) throws SQLException;

	/**
	 * 动态更新
	 * 
	 * @param t
	 * @throws SQLException
	 */
	void updateSelective(T t) throws SQLException;

	/**
	 * 指定编号删除
	 * 
	 * @param id
	 * @throws SQLException
	 */
	void delByPrimaryKey(int id) throws SQLException;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> getAll();

	/**
	 * 查询单个
	 * 
	 * @param id
	 * @return
	 */
	T selectByPrimaryKey(int id);

}
