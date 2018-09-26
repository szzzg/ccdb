package com.movitech.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年9月24日下午11:39:41
 * @author: 周志刚
 * @ClassName: CrossOriginFilter
 * @Description: TODO
 */
public class CrossOriginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg1, ServletResponse arg2, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("跨域过滤器");
		HttpServletRequest request = (HttpServletRequest) arg1;
		HttpServletResponse response = (HttpServletResponse) arg2;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

		chain.doFilter(request, response);

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
