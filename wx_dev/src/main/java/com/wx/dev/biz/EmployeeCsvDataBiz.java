package com.wx.dev.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.dev.dao.TblEmployeecsvdataMapper;
import com.wx.dev.entity.TblEmployeecsvdata;
import com.wx.dev.entity.TblEmployeecsvdataExample;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年3月7日下午6:43:17
 * @author: 周志刚
 * @ClassName: EmployeeCsvDataBiz
 * @Description: TODO
 */
@Service
public class EmployeeCsvDataBiz implements IComMethod<TblEmployeecsvdata> {

	@Resource
	private TblEmployeecsvdataMapper mapper;

	@Override
	public void saveSelective(TblEmployeecsvdata t) throws SQLException {
		// TODO Auto-generated method stub
		mapper.insertSelective(t);
	}

	@Override
	public void updateSelective(TblEmployeecsvdata t) throws SQLException {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKey(t);
	}

	@Override
	public void delByPrimaryKey(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TblEmployeecsvdata> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TblEmployeecsvdata selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public TblEmployeecsvdata selectByCsv(String oldCode) {
		TblEmployeecsvdataExample example = new TblEmployeecsvdataExample();
		example.createCriteria().andOldcodeEqualTo(oldCode);
		List<TblEmployeecsvdata> list = mapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
