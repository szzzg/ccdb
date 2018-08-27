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
 * @version create time：2018年8月9日下午1:11:35
 * @author: 周志刚
 * @ClassName: TokenFilter
 * @Description: TODO
 */
public class TokenFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllllllll");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		arg2.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
