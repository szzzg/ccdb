package com.wx.dev.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.util.UrlConnUtils;
import com.wx.dev.util.WXCallBackParamUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年1月20日下午4:32:16
 * @author: 周志刚
 * @ClassName: WXjsSdkController
 * @Description: TODO
 */
@Controller
@RequestMapping("/jssdk")
public class WXjsSdkController {

	@RequestMapping(value = "/getSdkConfigParam", method = RequestMethod.POST)
	public void getSdkConfigParam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");

		String urlAddr = request.getParameter("urlAddr");
		String urlStr[] = urlAddr.split("#");
		String url = urlStr[0];

		String paramCorpid = "wx0fb1e39f79174fd2";
		String paramCorpsecret = "EGO4QuoMyFTQfzHLdKPvUb70JJIfSXXnGN-o36l1nfi75h4P3N0DMXE6sFa1r_OA";

		long timestamp = System.currentTimeMillis() / 1000;
		String nonceStr = UUID.randomUUID().toString();

		// 获取token
		String accessToken = WXCallBackParamUtils.getAccessToken(paramCorpid,
				paramCorpsecret);
		// 获取ticket
		String ticket = WXCallBackParamUtils.Get_JsApi_Ticket(accessToken);
		// 获取signature
		String signature = WXCallBackParamUtils.getSignature(ticket, timestamp,
				nonceStr, url);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("appId", paramCorpid);
		jsonObject.put("timestamp", timestamp);
		jsonObject.put("nonceStr", nonceStr);
		jsonObject.put("signature", signature);

		System.out.println(jsonObject);

		response.getWriter().print(jsonObject);
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {

		return "/cameraScan";
	}
}
