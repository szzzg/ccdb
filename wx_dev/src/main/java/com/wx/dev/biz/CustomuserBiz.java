package com.wx.dev.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.dev.dao.TblCustomuserMapper;
import com.wx.dev.entity.TblCustomuser;
import com.wx.dev.entity.TblCustomuserExample;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月5日下午2:38:02
 * @author: 周志刚
 * @ClassName: CustomuserBiz
 * @Description: TODO
 */
@Service
public class CustomuserBiz implements IComMethod<TblCustomuser> {

	@Resource
	private TblCustomuserMapper userMapper;

	@Override
	public void saveSelective(TblCustomuser t) throws SQLException {
		// TODO Auto-generated method stub
		userMapper.insertSelective(t);
	}

	@Override
	public void updateSelective(TblCustomuser t) throws SQLException {
		// TODO Auto-generated method stub
		TblCustomuserExample example = new TblCustomuserExample();
		example.createCriteria().andCorpidEqualTo(t.getCorpid())
				.andUseridEqualTo(t.getUserid());
		userMapper.updateByExampleSelective(t, example);
	}

	@Override
	public void delByPrimaryKey(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TblCustomuser> getAll() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}

	@Override
	public TblCustomuser selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int countSelectByUserId(TblCustomuser t) {

		TblCustomuserExample example = new TblCustomuserExample();
		example.createCriteria().andCorpidEqualTo(t.getCorpid())
				.andUseridEqualTo(t.getUserid());

		return userMapper.countByExample(example);
	}

	/**
	 * 根据CorpId获取用户
	 * 
	 * @param corpId
	 * @return
	 */
	public List<TblCustomuser> getAll(String corpId) {
		// TODO Auto-generated method stub
		TblCustomuserExample example = new TblCustomuserExample();
		example.createCriteria().andCorpidEqualTo(corpId);
		return userMapper.selectByExample(example);
	}

}
