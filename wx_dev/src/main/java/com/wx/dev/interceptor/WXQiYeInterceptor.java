package com.wx.dev.interceptor;

import java.net.URLEncoder;
import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.util.AccessTokenUtil;
import com.wx.dev.util.UrlConnUtils;

import net.sf.json.JSONObject;

/**
 * @ProjectName: wx_dev
 * @version create time：2018年9月13日上午10:35:08
 * @author: 周志刚
 * @ClassName: WXQiYeInterceptor
 * @Description: TODO
 */
public class WXQiYeInterceptor extends HandlerInterceptorAdapter {

	Log _log = LogFactory.getLog(WXQiYeInterceptor.class);

	String appid = AccessTokenUtil.CORP_ID;
	String agentid = "1000002";
	String redirect_uri = "";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		_log.info(request.getRequestURL().toString());

		if (session.getAttribute("UserId") == null) {
			String code = request.getParameter("code");
			if (StringUtils.isBlank(code)) {
				redirect_uri = URLEncoder.encode(request.getRequestURL().toString(), "utf-8");
				String oauthUrl = MessageFormat.format(WxCorpApiConstant.oauth2_url, appid, redirect_uri, agentid);
				_log.info("根据OAuth身份认证去获取权限CODE");
				response.sendRedirect(oauthUrl);
			} else {
				Object userId = session.getAttribute("UserId");
				if (userId == null) {
					// 获取微信企业号的用户UserId
					String getUserIdUrl = MessageFormat.format(WxCorpApiConstant.GET_USERINFO_BY_CODE,
							AccessTokenUtil.getToken(), code);
					_log.info("OAuth身份认证通过后获取通过接口拿到当前用户");
					String userinfoJson = UrlConnUtils.getUrlConn(getUserIdUrl);
					userId = JSONObject.fromObject(userinfoJson).getString("UserId");
					session.setAttribute("UserId", userId);

					_log.info("根据自己业务获取用户信息");
					// 根据自己业务获取用户信息(业务表或企业号接口拿相关信息)
					String userUrl = MessageFormat.format(WxCorpApiConstant.Get_User_URL, AccessTokenUtil.getToken(),
							userId);
					UrlConnUtils.getUrlConn(userUrl);
					// SESSION 存储用户信息

					return true;
				}
			}
		}

		return false;
	}

}
