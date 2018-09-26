package com.wx.dev.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @ProjectName: wx_dev
 * @version create time：2018年9月13日下午5:43:49
 * @author: 周志刚
 * @ClassName: DoubleCheckingInterceptor
 * @Description: TODO
 */
public class DoubleCheckingInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return false;
	}

}
