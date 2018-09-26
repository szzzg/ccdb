package com.wx.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: wx_dev
 * @version create time：2018年9月26日下午4:50:05
 * @author: 周志刚
 * @ClassName: UserController
 * @Description: TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 用户的登录
	 * 
	 * @param username
	 * @param userpwd
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(String username, String userpwd, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if ("sjsza59842K".equals(userpwd)) {
			session.setAttribute("SESSION_USER", username);
		}
		Object realPath = session.getAttribute("SESSION_REALPATH");
		if (realPath == null)
			return "/demo/hello";
		session.removeAttribute("SESSION_REALPATH");
		return "redirect:" + realPath;

	}

	/**
	 * 注销session
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/invalidate", method = RequestMethod.GET)
	public String invalidate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
