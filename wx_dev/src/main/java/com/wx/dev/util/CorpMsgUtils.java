package com.wx.dev.util;

import java.io.IOException;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.constant.WxCorpApiConstant.MEDIA_TYPE;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年6月14日下午1:19:53
 * @author: 周志刚
 * @ClassName: CorpMsgUtils
 * @Description: TODO
 */
public class CorpMsgUtils {

	/**
	 * 图文推送(带封面)
	 * 
	 * @param toUser
	 *            发送人
	 * @param toParty
	 *            发送组织
	 * @param msgType
	 *            类型
	 * @param agentId
	 *            应用Id
	 * @param title
	 *            标题
	 * @param mediaId
	 *            图文消息缩略图的media_id
	 * @param author
	 *            图文消息的作者
	 * @param contentSrcUrl
	 *            图文消息点击“阅读原文”之后的页面链接
	 * @param content
	 *            图文消息的内容
	 * @param digest
	 *            图文消息的描述
	 * @param safe
	 *            是否保密消息
	 * @return
	 */
	public static JSONObject generateMpNewsMsgJson(String toUser,
			String toParty, String msgType, int agentId, String title,
			String mediaId, String author, String contentSrcUrl,
			String content, String digest, boolean safe) {
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotEmpty(toUser)) {
			jsonObject.put("touser", toUser);
		}
		if (StringUtils.isNotEmpty(toParty)) {
			jsonObject.put("toparty", toParty);
		}
		jsonObject.put("msgtype", msgType);
		jsonObject.put("agentid", agentId);

		JSONObject jsonObj = new JSONObject();

		JSONArray jsonArray = new JSONArray();
		JSONObject subJsonObj = new JSONObject();
		subJsonObj.put("title", title);
		subJsonObj.put("thumb_media_id", mediaId);
		if (StringUtils.isNotEmpty(author)) {
			subJsonObj.put("author", author);
		}
		if (StringUtils.isNotEmpty(contentSrcUrl)) {
			subJsonObj.put("content_source_url", contentSrcUrl);
		}
		subJsonObj.put("content", content);
		if (StringUtils.isNotEmpty(digest)) {
			subJsonObj.put("digest", digest);
		}
		jsonArray.add(subJsonObj);

		jsonObj.put("articles", jsonArray);
		jsonObject.put("mpnews", jsonObj);

		if (safe) {
			jsonObject.put("safe", 1);
		}
		return jsonObject;
	}

	/**
	 * 图文推送(标准)
	 * 
	 * @param toUser
	 *            发送人
	 * @param toParty
	 *            发送组织
	 * @param msgType
	 *            类型
	 * @param agentId
	 *            应用ID
	 * @param title
	 *            标题
	 * @param description
	 *            图文内容
	 * @param url
	 *            点击后跳转的链接
	 * @param picurl
	 *            图文消息的图片链接，支持JPG、PNG格式
	 * @return
	 */
	public static JSONObject generateNewsMsgJson(String toUser, String toParty,
			String msgType, int agentId, String title, String description,
			String url, String picurl) {
		JSONObject jsonObject = new JSONObject();
		if (StringUtils.isNotEmpty(toUser)) {
			jsonObject.put("touser", toUser);
		}
		if (StringUtils.isNotEmpty(toParty)) {
			jsonObject.put("toparty", toParty);
		}
		jsonObject.put("msgtype", msgType);
		jsonObject.put("agentid", agentId);

		JSONObject jsonObj = new JSONObject();

		JSONArray jsonArray = new JSONArray();
		JSONObject subJsonObj = new JSONObject();
		subJsonObj.put("title", title);
		if (StringUtils.isNotEmpty(description)) {
			subJsonObj.put("description", description);
		}
		subJsonObj.put("url", url);
		if (StringUtils.isNotEmpty(picurl)) {
			subJsonObj.put("picurl", picurl);
		}
		jsonArray.add(subJsonObj);

		jsonObj.put("articles", jsonArray);
		jsonObject.put("news", jsonObj);

		return jsonObject;

	}

	/**
	 * 发送图文消息
	 * 
	 * @throws IOException
	 */
	@Test
	public void sendMpNews() throws IOException {
		String token = WXCallBackParamUtils
				.getAccessToken("wx8c4e63af577f33a9",
						"_fUGDjprqXqfxiUYTLx2f4YLV4HawWlBDG44yymEw5PcP1joaGL6kDSvFR9997nd");
		String type = MEDIA_TYPE.file.name();
		String postUrl = MessageFormat.format(
				WxCorpApiConstant.CGI_MEDIA_UPLOAD, token, type);

		String mediaFileUrl = "D:/Matrix/danone_logo.png";

		JSONObject jsonObject = MediaUploadUtil.uploadMedia(postUrl,
				mediaFileUrl);

		String media_id = jsonObject.getString("media_id");

		JSONObject jsonObj = generateMpNewsMsgJson("brain|holly", null,
				"mpnews", 7, "你需要今天拜访0位客户", media_id, null,
				"http://www.qq.com", "&nbsp;", null, false);

		String sendMsgUrl = MessageFormat.format(WxCorpApiConstant.SEND_MSG,
				token);

		UrlConnUtils.postUrlConn(sendMsgUrl, jsonObj.toString());
	}

	/**
	 * 发送图文消息
	 * 
	 * @throws IOException
	 */
	@Test
	public void sendNews() throws IOException {
		String token = WXCallBackParamUtils
				.getAccessToken("wx8c4e63af577f33a9",
						"_fUGDjprqXqfxiUYTLx2f4YLV4HawWlBDG44yymEw5PcP1joaGL6kDSvFR9997nd");
		JSONObject jsonObj = generateNewsMsgJson("brain", null, "news", 7,
				"你需要今天拜访0位客户", null, "http://www.qq.com", "");
		System.out.println(jsonObj);

		String sendMsgUrl = MessageFormat.format(WxCorpApiConstant.SEND_MSG,
				token);

		UrlConnUtils.postUrlConn(sendMsgUrl, jsonObj.toString());
	}
}
