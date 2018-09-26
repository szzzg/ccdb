package com.wx.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年1月23日下午2:34:48
 * @author: 周志刚
 * @ClassName: DemoController
 * @Description: TODO
 */

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping(value = "/view/{number}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable String number) {

		model.addAttribute("el_number", number);
		return "/demo/hello";
	}

}
