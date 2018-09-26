package com.wx.dev.quartz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.wx.dev.biz.CorpInfoBiz;
import com.wx.dev.biz.CustomuserBiz;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.entity.TblCorpinfo;
import com.wx.dev.entity.TblCustomuser;
import com.wx.dev.util.UrlConnUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月5日下午4:59:22
 * @author: 周志刚
 * @ClassName: WxUserJob
 * @Description: TODO
 */
@Repository
public class WxUserJob {

	Log _log = LogFactory.getLog(WxUserJob.class);

	@Resource
	private CorpInfoBiz corpInfoBiz;
	@Resource
	private CustomuserBiz customBiz;

	public void syncWxUser() {
		_log.info("WxUserJob定时程序启用:syncWxUser");
		// 获取所有企业号信息
		List<TblCorpinfo> listCorpInfo = corpInfoBiz.getAll();
		for (TblCorpinfo corpinfo : listCorpInfo) {

			_log.info("进入企业号【" + corpinfo.getCorpname() + "】进行同步用户");

			// 获取根节点下的组织结构的所有成员
			String getUrl = MessageFormat.format(
					WxCorpApiConstant.Get_DeptUser_URL, corpinfo.getAccesstoken(),
					"1", "1", "0");
			Date updDate = new Date();
			try {
				String wxResult = UrlConnUtils.getUrlConn(getUrl);
				JSONObject jsonObject = JSONObject.fromObject(wxResult);
				JSONArray jsonArray = JSONArray.fromObject(jsonObject
						.get("userlist"));

				for (Object obj : jsonArray) {
					JSONObject jsonObj = JSONObject.fromObject(obj);
					TblCustomuser user = new TblCustomuser();
					user.setCorpid(corpinfo.getCorpid());
					user.setUserid(jsonObj.getString("userid"));
					user.setName(jsonObj.getString("name"));
					user.setDepartment(jsonObj.getString("department"));
					if (jsonObj.containsKey("position")) {
						user.setPosition(jsonObj.getString("position"));
					}
					if (jsonObj.containsKey("mobile")) {
						user.setMobile(jsonObj.getString("mobile"));
					}
					if (jsonObj.containsKey("gender")) {
						user.setGender(jsonObj.getInt("gender"));
					}
					if (jsonObj.containsKey("email")) {
						user.setEmail(jsonObj.getString("email"));
					}
					if (jsonObj.containsKey("position")) {
						user.setWeixinid(jsonObj.getString("position"));
					}
					if (jsonObj.containsKey("avatar")) {
						user.setAvatar(jsonObj.getString("avatar"));
					}
					if (jsonObj.containsKey("status")) {
						user.setStatus(jsonObj.getInt("status"));
					}
					if (jsonObj.containsKey("extattr")) {
						user.setExtattr(jsonObj.getString("extattr"));
					}

					try {
						if (customBiz.countSelectByUserId(user) > 0) {
							user.setUpddate(updDate);
							customBiz.updateSelective(user);
						} else {
							customBiz.saveSelective(user);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		_log.info("WxUserJob定时程序结束:syncWxUser");
	}
}
