package com.wx.dev.util;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.codec.digest.DigestUtils;

import net.sf.json.JSONObject;

import com.wx.dev.constant.WxCorpApiConstant;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年1月20日下午5:28:09
 * @author: 周志刚
 * @ClassName: WXCallBackParamUtils
 * @Description: TODO
 */
public class WXCallBackParamUtils {

	/**
	 * 获取AccessToken
	 * 
	 * @param corpId
	 * @param corpSecret
	 * @return
	 * @throws IOException
	 */
	public static String getAccessToken(String corpId, String corpSecret)
			throws IOException {
		String getUrl = MessageFormat.format(
				WxCorpApiConstant.GET_AccessToken_URL, corpId, corpSecret);
		String wxResult = UrlConnUtils.getUrlConn(getUrl);
		JSONObject jsonResult = JSONObject.fromObject(wxResult);
		return jsonResult.getString("access_token");
	}

	/**
	 * 获取JsApi_Ticket
	 * 
	 * @param accessToken
	 * @return
	 * @throws IOException
	 */
	public static String Get_JsApi_Ticket(String accessToken)
			throws IOException {
		String getUrl = MessageFormat.format(
				WxCorpApiConstant.Get_JsApi_Ticket, accessToken);
		String wxResult = UrlConnUtils.getUrlConn(getUrl);
		JSONObject jsonResult = JSONObject.fromObject(wxResult);
		return jsonResult.getString("ticket");
	}

	/**
	 * 获取Signature
	 * 
	 * @param ticket
	 * @param timestamp
	 * @param nonceStr
	 * @param url
	 * @return
	 */
	public static String getSignature(String ticket, long timestamp,
			String nonceStr, String url) {
		String spliceStr = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr
				+ "&timestamp=" + timestamp + "&url=" + url;
		return DigestUtils.sha1Hex(spliceStr);
	}
}
