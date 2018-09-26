package com.wx.dev.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.dev.dao.TblMulitDataMapper;
import com.wx.dev.entity.TblMulitData;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月13日下午3:58:13
 * @author: 周志刚
 * @ClassName: MulitDataBiz
 * @Description: TODO
 */
@Service
public class MulitDataBiz implements IComMethod<TblMulitData> {

	@Resource
	private TblMulitDataMapper mulitDataMapper;

	@Override
	public void saveSelective(TblMulitData t) throws SQLException {
		// TODO Auto-generated method stub
		mulitDataMapper.insertSelective(t);
	}

	@Override
	public void updateSelective(TblMulitData t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delByPrimaryKey(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TblMulitData> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TblMulitData selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
