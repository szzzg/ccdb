package dev.test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.dev.biz.CustomuserBiz;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.entity.TblCustomuser;
import com.wx.dev.util.UrlConnUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月5日下午2:26:30
 * @author: 周志刚
 * @ClassName: WxUser
 * @Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class WxUser {

	@Resource
	private CustomuserBiz customBiz;
	String accessToken = "BgQxC3NdT5appE1nttJYdsrhlAYBORYQ1htna2n748i4SPqTdbFUgt3qIl0_b21X";
	String corpId = "wx4b7dbf5ff1329664";

	/**
	 * 同步企业号通讯录数据到本地库
	 */
	@Test
	public void testLoadUser() {
		// String getUrl = MessageFormat.format(
		// WxCorpApiConstant.Get_DeptUser_URL, accessToken, "1", "1", "0");
		String getUrl = MessageFormat
				.format(WxCorpApiConstant.Get_DeptUser_URL, accessToken, "25",
						"1", "2");

		Date updDate = new Date();

		try {
			String wxResult = UrlConnUtils.getUrlConn(getUrl);
			JSONObject jsonObject = JSONObject.fromObject(wxResult);
			JSONArray jsonArray = JSONArray.fromObject(jsonObject
					.get("userlist"));

			for (Object obj : jsonArray) {
				JSONObject jsonObj = JSONObject.fromObject(obj);
				TblCustomuser user = new TblCustomuser();
				user.setCorpid(corpId);
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

		System.out.println(customBiz.getAll().size());
	}

	/**
	 * 更新企业号通讯录中用户数据状态
	 * 
	 * @throws IOException
	 */
	// @Test
	public void updateUserStatus() throws IOException {
		List<TblCustomuser> listUser = customBiz.getAll(corpId);
		for (TblCustomuser user : listUser) {
			if (user.getStatus() == 2) {
				JSONObject postData = new JSONObject();
				postData.put("userid", user.getUserid());
				postData.put("name", user.getName());
				postData.put("department", user.getDepartment());
				postData.put("position", user.getPosition());
				postData.put("mobile", user.getMobile());
				postData.put("gender", user.getGender());
				if (StringUtils.isNotEmpty(user.getEmail())) {
					postData.put("email", user.getEmail());
				}
				if (StringUtils.isNotEmpty(user.getWeixinid())) {
					postData.put("weixinid", user.getWeixinid());
				}
				postData.put("enable", 1);
				postData.put("extattr", user.getExtattr());
				System.out.println(postData.toString());
				String postUrl = MessageFormat.format(
						WxCorpApiConstant.Update_User_URL, accessToken);
				UrlConnUtils.postUrlConn(postUrl, postData.toString());
			}
		}
	}

}
