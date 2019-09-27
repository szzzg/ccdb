package com.wx.dev.controller;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
//import org.jasig.cas.client.authentication.AttributePrincipal;
//import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.dev.biz.CorpInfoBiz;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.entity.TblCorpinfo;
import com.wx.dev.util.UrlConnUtils;

import net.sf.json.JSONObject;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月25日下午3:28:03
 * @author: 周志刚
 * @ClassName: WXqiyeController
 * @Description: TODO
 */
@Controller
@RequestMapping("/qiye")
public class WXqiyeController {

	@Resource
	private CorpInfoBiz corpInfoBiz;

	@RequestMapping(value = "/dispacthCorpInfo", method = RequestMethod.GET)
	public String dispatchCorpInfo(Model model, HttpServletRequest request) {

		// _const_cas_assertion_是CAS中存放登录用户名的session标志
		Object object = request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);

		if (object != null) {
			Assertion assertion = (Assertion) object;
			String loginName = assertion.getPrincipal().getName();
			System.out.println("[loginname]: " + loginName);

			Map<String, Object> map = assertion.getPrincipal().getAttributes();
			String email = (String) map.get("email");
			String name = (String) map.get("name");
			String phone = (String) map.get("phone");
			String mark = (String) map.get("mark");
			String username = (String) map.get("username");
			System.out.println("[email]: " + email);
			System.out.println("[name]: " + name);
			System.out.println("[mark]: " + mark);
			System.out.println("[phone]: " + phone);
			System.out.println("[username]: " + username);
		}

		AttributePrincipal principal = (AttributePrincipal) request
				.getUserPrincipal();
		System.out.println(principal.getName());
		Map attributes = principal.getAttributes();
		String email = (String) attributes.get("email");
		String name = (String) attributes.get("name");
		String phone = (String) attributes.get("phone");
		String mark = (String) attributes.get("mark");
		String username = (String) attributes.get("username");
		System.out.println("[email]: " + email);
		System.out.println("[name]: " + name);
		System.out.println("[phone]: " + phone);
		System.out.println("[mark]: " + mark);
		System.out.println("[username]: " + username);

		model.addAttribute("jstl_corpInfoLst", corpInfoBiz.getAll());
		return "/corpInfo";
	}

	@RequestMapping(value = "/saveCorpInfo", method = RequestMethod.POST)
	public String saveCorpInfo(HttpServletRequest request,
			TblCorpinfo corpinfo, Model model) {

		if (!corpInfoBiz.existsCorpInfo(corpinfo)) {
			try {
				corpInfoBiz.saveSelective(corpinfo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "redirect:dispacthCorpInfo";
	}

	@RequestMapping(value = "/accessToken/{id}", method = RequestMethod.GET)
	public String generateAccessToken(@PathVariable int id) {
		TblCorpinfo corpinfo = corpInfoBiz.selectByPrimaryKey(id);
		String postUrl = MessageFormat.format(
				WxCorpApiConstant.GET_AccessToken_URL, corpinfo.getCorpid(),
				corpinfo.getCorpsecret());
		try {
			String wxResult = UrlConnUtils.getUrlConn(postUrl);
			JSONObject jsonResult = JSONObject.fromObject(wxResult);
			corpinfo.setAccesstoken(jsonResult.get("access_token").toString());

			corpInfoBiz.updateSelective(corpinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/qiye/dispacthCorpInfo";
	}
}
