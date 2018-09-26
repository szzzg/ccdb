package com.wx.dev.util;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月5日下午6:09:03
 * @author: 周志刚
 * @ClassName: CorpMsgTemplate
 * @Description: TODO
 */
public class CorpMsgTemplate {

	public static final String TEXT = "text";
	public static final String IMAGE = "image";
	public static final String VOICE = "voice";
	public static final String VIDEO = "video";
	public static final String FILE = "file";
	public static final String NEWS = "news";
	public static final String MPNEWS = "mpnews";

	/**
	 * 普通消息
	 * 
	 * @param toUser
	 *            成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，
	 *            则向关注该企业应用的全部成员发送
	 * @param toParty
	 *            部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
	 * @param msgType
	 *            消息类型，此时固定为：text （支持消息型应用跟主页型应用）
	 * @param agentId
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param content
	 *            消息内容，最长不超过2048个字节，注意：主页型应用推送的文本消息在微信端最多只显示20个字（包含中英文）
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 * @return
	 */
	public static JSONObject generateTextMsgJson(String toUser, String toParty,
			String msgType, int agentId, String content, boolean safe) {
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
		jsonObj.put("content", content);

		jsonObject.put(msgType, jsonObj);
		if (safe) {
			jsonObject.put("safe", 1);
		}
		return jsonObject;
	}

	/**
	 * 媒体消息
	 * 
	 * @param toUser
	 *            成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，
	 *            则向关注该企业应用的全部成员发送
	 * @param toParty
	 *            部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
	 * @param msgType
	 *            消息类型，此时固定为：image、voice、video、file这几种类型（不支持主页型应用）
	 * @param agentId
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param mediaId
	 *            图片媒体文件id，可以调用上传临时素材或者永久素材接口获取,永久素材media_id必须由发消息的应用创建
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 * @return
	 */
	public static JSONObject generateMediaMsgJson(String toUser,
			String toParty, String msgType, int agentId, String mediaId,
			boolean safe) {
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
		if (CorpMsgTemplate.IMAGE.equals(msgType)) {
			jsonObj.put("media_id", mediaId);
		} else if (CorpMsgTemplate.VOICE.equals(msgType)) {
			jsonObj.put("media_id", mediaId);
		} else if (CorpMsgTemplate.VIDEO.equals(msgType)) {
			jsonObj.put("media_id", mediaId);
		} else if (CorpMsgTemplate.FILE.equals(msgType)) {
			jsonObj.put("media_id", mediaId);
		}

		jsonObject.put(msgType, jsonObj);
		if (safe) {
			jsonObject.put("safe", 1);
		}
		return jsonObject;
	}
}
