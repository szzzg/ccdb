package com.wx.dev.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.dev.biz.CustomorganizationBiz;
import com.wx.dev.util.entity.ZTreeObj;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年2月20日上午11:10:24
 * @author: 周志刚
 * @ClassName: ZtreeController
 * @Description: TODO
 */
@Controller
@RequestMapping("/ztree")
public class ZtreeController {

	@Resource
	private CustomorganizationBiz organizationBiz;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewTree(Model model) {

		List<ZTreeObj> orgs = organizationBiz.getMenu(
				"wxe3489563252df116", 1);
		for (ZTreeObj org : orgs) {
			org.setChildren(organizationBiz.getMenu("wxe3489563252df116",
					org.getId()));
		}
		model.addAttribute("jsonObj", JSONArray.fromObject(orgs));

		return "ztree/menu_tree";
	}
}
