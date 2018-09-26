package com.wx.dev.quartz;

import java.text.MessageFormat;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.wx.dev.biz.CorpInfoBiz;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.entity.TblCorpinfo;
import com.wx.dev.util.UrlConnUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年11月28日下午2:10:35
 * @author: 周志刚
 * @ClassName: WxRefreshAccessTokenJob
 * @Description: 定时刷新微信企业号API接口的AccessToken
 */
@Repository
public class WxRefreshAccessTokenJob {

	Log _log = LogFactory.getLog(WxRefreshAccessTokenJob.class);

	@Resource
	private CorpInfoBiz corpInfoBiz;

	public void operat() {
		_log.info("WxRefreshAccessTokenJob定时程序启用");

		// 获取所有企业号信息
		List<TblCorpinfo> listCorpInfo = corpInfoBiz.getAll();

		for (TblCorpinfo corpinfo : listCorpInfo) {
			String postUrl = MessageFormat.format(
					WxCorpApiConstant.GET_AccessToken_URL, corpinfo.getCorpid(),
					corpinfo.getCorpsecret());
			try {
				String wxResult = UrlConnUtils.getUrlConn(postUrl);

				_log.info("返回JSON>>>>>" + wxResult);

				JSONObject jsonResult = JSONObject.fromObject(wxResult);
				corpinfo.setAccesstoken(jsonResult.get("access_token")
						.toString());

				corpInfoBiz.updateSelective(corpinfo);
			} catch (Exception e) {
				_log.error(e);
			}
		}
		_log.info("WxRefreshAccessTokenJob定时程序结束");
	}

}
