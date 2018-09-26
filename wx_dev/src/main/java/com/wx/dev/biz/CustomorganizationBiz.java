package com.wx.dev.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.dev.dao.TblCustomorganizationMapper;
import com.wx.dev.entity.TblCustomorganization;
import com.wx.dev.entity.TblCustomorganizationExample;
import com.wx.dev.util.entity.TreeCondition;
import com.wx.dev.util.entity.ZTreeObj;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月2日下午2:50:23
 * @author: 周志刚
 * @ClassName: CustomorganizationBiz
 * @Description: TODO
 */
@Service
public class CustomorganizationBiz implements IComMethod<TblCustomorganization> {

	@Resource
	private TblCustomorganizationMapper customorganizationMapper;

	@Override
	public void saveSelective(TblCustomorganization t) throws SQLException {

		customorganizationMapper.insertSelective(t);
	}

	@Override
	public void updateSelective(TblCustomorganization t) throws SQLException {

		TblCustomorganizationExample example = commonSearchCondition(t);
		customorganizationMapper.updateByExampleSelective(t, example);

	}

	@Override
	public void delByPrimaryKey(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TblCustomorganization> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TblCustomorganization selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TblCustomorganization> listCustomorganization(String corpId,
			int parentId) {
		TblCustomorganizationExample example = new TblCustomorganizationExample();
		example.createCriteria().andCorpidEqualTo(corpId)
				.andParentidEqualTo(parentId);
		return customorganizationMapper.selectByExample(example);
	}

	public void delBySelective(TblCustomorganization t) {
		TblCustomorganizationExample example = commonSearchCondition(t);
		customorganizationMapper.deleteByExample(example);
	}

	/**
	 * 公共查询条件
	 * 
	 * @param t
	 * @return
	 */
	public TblCustomorganizationExample commonSearchCondition(
			TblCustomorganization t) {
		TblCustomorganizationExample example = new TblCustomorganizationExample();
		example.createCriteria().andCorpidEqualTo(t.getCorpid())
				.andOrgidEqualTo(t.getOrgid());
		return example;
	}

	public int countBySelective(TblCustomorganization t) {
		TblCustomorganizationExample example = commonSearchCondition(t);

		return customorganizationMapper.countByExample(example);
	}

	public int countBySelective1(TblCustomorganization t) {
		TblCustomorganizationExample example = new TblCustomorganizationExample();
		example.createCriteria().andCorpidEqualTo(t.getCorpid())
				.andNameEqualTo(t.getName()).andParentidEqualTo(1);

		return customorganizationMapper.countByExample(example);
	}

	public int getMaxOrgId(TblCustomorganization t) {
		return customorganizationMapper.getMaxOrgId(t);
	}

	/**
	 * 获取顶级组织下所有一级组织
	 * 
	 * @param t
	 * @return
	 */
	public List<TblCustomorganization> getAll(String corpId) {
		TblCustomorganizationExample example = new TblCustomorganizationExample();
		example.createCriteria().andCorpidEqualTo(corpId).andParentidEqualTo(1);
		return customorganizationMapper.selectByExample(example);
	}

	public List<ZTreeObj> getMenu(String corpId, int orgId) {
		TreeCondition condition = new TreeCondition();
		condition.setCorpId(corpId);
		condition.setOrgId(orgId);
		return customorganizationMapper.getMenu(condition);
	}
}
