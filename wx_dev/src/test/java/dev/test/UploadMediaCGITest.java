package dev.test;

import java.io.IOException;
import java.text.MessageFormat;

import net.sf.json.JSONObject;

import org.junit.Test;

import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.constant.WxCorpApiConstant.MEDIA_TYPE;
import com.wx.dev.util.MediaUploadUtil;
import com.wx.dev.util.UrlConnUtils;
import com.wx.dev.util.WXCallBackParamUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2017年6月13日下午1:38:57
 * @author: 周志刚
 * @ClassName: UploadMediaCGITest
 * @Description: TODO
 */
public class UploadMediaCGITest {

	@Test
	public void synCsvToContract() throws IOException {
		String token = WXCallBackParamUtils
				.getAccessToken("wx8c4e63af577f33a9",
						"_fUGDjprqXqfxiUYTLx2f4YLV4HawWlBDG44yymEw5PcP1joaGL6kDSvFR9997nd");
		String type = MEDIA_TYPE.file.name();
		String postUrl = MessageFormat.format(
				WxCorpApiConstant.CGI_MEDIA_UPLOAD, token, type);

		String mediaFileUrl = "E:/batch_sale_user_20170612032544.csv";

		JSONObject jsonObject = MediaUploadUtil.uploadMedia(postUrl,
				mediaFileUrl);

		String media_id = jsonObject.getString("media_id");

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("media_id", media_id);
		JSONObject subJsonObj = new JSONObject();
		subJsonObj.put("url", "");
		subJsonObj.put("token", "");
		subJsonObj.put("encodingaeskey", "");

		jsonObj.put("callback", subJsonObj);

		String replaceUserUrl = MessageFormat.format(
				WxCorpApiConstant.REPLACE_USER, token);

		UrlConnUtils.postUrlConn(replaceUserUrl, jsonObj.toString());
	}
}
