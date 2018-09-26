package com.wx.dev.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年4月25日上午10:51:20
 * @author: 周志刚
 * @ClassName: DispatcherPageFilter
 * @Description: TODO
 */
public class DispatcherPageFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest arg1, ServletResponse arg2, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg1;
		HttpServletResponse response = (HttpServletResponse) arg2;
		HttpSession session = request.getSession();

		System.out.println("执行了过滤");
		System.out.println(request.getRequestURL().toString());
		Object userName = session.getAttribute("username");
		if (userName == null) {
			session.setAttribute("username", "张三");
			System.out.println("SESSION 有值");
		}
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {

	}

}
