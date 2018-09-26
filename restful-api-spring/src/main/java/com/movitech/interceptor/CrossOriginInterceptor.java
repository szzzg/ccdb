package com.movitech.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年9月24日下午11:22:54
 * @author: 周志刚
 * @ClassName: CrossOriginInterceptor
 * @Description: TODO
 */
public class CrossOriginInterceptor extends HandlerInterceptorAdapter {

	Log _log = LogFactory.getLog(CrossOriginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("跨域拦截器启动");

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

		return true;
	}

}
