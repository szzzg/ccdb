package com.wx.dev.util;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import com.wx.dev.constant.WxCorpApiConstant;

import net.sf.json.JSONObject;

/**
 * @ProjectName: wx_dev
 * @version create time：2018年9月13日上午10:37:54
 * @author: 周志刚
 * @ClassName: AccessTokenUtil
 * @Description: TODO
 */
public class AccessTokenUtil {

	public static final String CORP_ID = "wx2571de69f22ca4b3";
	public static final String CORP_SECRET = "jmv-QFTgwPJxHN1W35ZYXAmx2f_9UeBmV8vgA9yK2x5UQBX_0XyI-bALiaDKwSjA";
	public static String access_token = "";

	public static String getToken() {
		String getUrl = MessageFormat.format(WxCorpApiConstant.GET_AccessToken_URL, CORP_ID, CORP_SECRET);
		if (StringUtils.isBlank(access_token)) {
			try {
				String tokenJson = UrlConnUtils.getUrlConn(getUrl);
				access_token = JSONObject.fromObject(tokenJson).getString("access_token");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return access_token;
	}

	public static void main(String[] args) {
		System.out.println(AccessTokenUtil.getToken());
		System.out.println(AccessTokenUtil.getToken());
	}
}
