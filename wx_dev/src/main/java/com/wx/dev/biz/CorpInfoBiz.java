package com.wx.dev.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wx.dev.dao.TblCorpinfoMapper;
import com.wx.dev.entity.TblCorpinfo;
import com.wx.dev.entity.TblCorpinfoExample;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月21日下午4:58:17
 * @author: 周志刚
 * @ClassName: CorpInfoBiz
 * @Description: TODO
 */
@Service
public class CorpInfoBiz implements IComMethod<TblCorpinfo> {

	@Resource
	private TblCorpinfoMapper corpinfoMapper;

	@Override
	public void saveSelective(TblCorpinfo t) throws SQLException {
		corpinfoMapper.insertSelective(t);
	}

	@Override
	public void updateSelective(TblCorpinfo t) throws SQLException {

		corpinfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public void delByPrimaryKey(int id) throws SQLException {

	}

	@Override
	public List<TblCorpinfo> getAll() {
		return corpinfoMapper.selectByExample(null);
	}

	@Override
	public TblCorpinfo selectByPrimaryKey(int id) {
		return corpinfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * 企业号是否存在
	 * 
	 * @param t
	 * @return
	 */
	public boolean existsCorpInfo(TblCorpinfo t) {

		TblCorpinfoExample example = new TblCorpinfoExample();
		example.createCriteria().andCorpidEqualTo(t.getCorpid())
				.andCorpsecretEqualTo(t.getCorpsecret());
		if (corpinfoMapper.countByExample(example) > 0)
			return true;
		return false;
	}

}
