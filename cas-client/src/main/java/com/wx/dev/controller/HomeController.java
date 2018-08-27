package com.wx.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: cas-client
 * @version create time：2018年7月30日上午10:08:23
 * @author: 周志刚
 * @ClassName: HomeController
 * @Description: TODO
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String mainPage(Model model) {
		model.addAttribute("sayHi", "你好,");
		model.addAttribute("name", "brain");
		model.addAttribute("sayHillo", " 早上好");

		return "/home/main";
	}
}
