package com.wx.dev.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @ProjectName: wx_dev
 * @version create time：2018年9月26日下午4:37:14
 * @author: 周志刚
 * @ClassName: LoginInterceptor
 * @Description: 登录拦截(记录请求URL，方便登录后快速回到当前页)
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		Object user = session.getAttribute("SESSION_USER");
		if (user == null) {

			response.sendRedirect("/wx_dev");
			String uri = request.getRequestURI();
			String path = uri.substring(request.getContextPath().length());// 去掉项目地址长度的字符（因为我的默认项目地址是给出的）
			String queryStr = request.getQueryString();
			String realUrl = queryStr == null ? path : path + "?" + queryStr;
			session.setAttribute("SESSION_REALPATH", realUrl);

			return false;
		} else {
			return true;
		}
	}

}
