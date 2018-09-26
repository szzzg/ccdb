package com.wx.dev.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.dev.dao.TblDeptcsvdataMapper;
import com.wx.dev.entity.TblDeptcsvdata;
import com.wx.dev.entity.TblDeptcsvdataExample;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月22日下午3:13:44
 * @author: 周志刚
 * @ClassName: DeptCsvDataBiz
 * @Description: TODO
 */
@Service
public class DeptCsvDataBiz implements IComMethod<TblDeptcsvdata> {

	@Resource
	private TblDeptcsvdataMapper deptcsvdataMapper;

	@Override
	public void saveSelective(TblDeptcsvdata t) throws SQLException {
		// TODO Auto-generated method stub
		deptcsvdataMapper.insertSelective(t);
	}

	@Override
	public void updateSelective(TblDeptcsvdata t) throws SQLException {
		// TODO Auto-generated method stub
		deptcsvdataMapper.updateByPrimaryKeySelective(t);

	}

	@Override
	public void delByPrimaryKey(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TblDeptcsvdata> getAll() {
		// TODO Auto-generated method stub
		return deptcsvdataMapper.selectByExample(null);
	}

	@Override
	public TblDeptcsvdata selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int countSelectByCondition(TblDeptcsvdata t) {
		TblDeptcsvdataExample example = new TblDeptcsvdataExample();
		example.createCriteria().andCodeEqualTo(t.getCode())
				.andCbuEqualTo(t.getCbu());
		return deptcsvdataMapper.countByExample(example);
	}

}
