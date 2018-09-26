package com.wx.dev.quartz;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.wx.dev.biz.CorpInfoBiz;
import com.wx.dev.biz.CustomorganizationBiz;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.entity.TblCorpinfo;
import com.wx.dev.entity.TblCustomorganization;
import com.wx.dev.util.UrlConnUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月2日下午4:35:44
 * @author: 周志刚
 * @ClassName: WxDeptJob
 * @Description: 通讯录组织架构定时程序
 */
@Repository
public class WxDeptJob {
	Log _log = LogFactory.getLog(WxDeptJob.class);

	@Resource
	private CorpInfoBiz corpInfoBiz;
	@Resource
	private CustomorganizationBiz organizationBiz;

	/**
	 * 企业号线上通讯录组织架构同步
	 */
	public void syncDept() {
		_log.info("WxDeptJob定时程序启用:syncDept");
		// 获取所有企业号信息
		List<TblCorpinfo> listCorpInfo = corpInfoBiz.getAll();
		for (TblCorpinfo corpinfo : listCorpInfo) {

			_log.info("进入企业号【" + corpinfo.getCorpname() + "】进行同步组织架构");

			// 获取根节点下的组织结构
			String getUrl = MessageFormat.format(WxCorpApiConstant.Get_Dept_URL,
					corpinfo.getAccesstoken(), WxCorpApiConstant.RootNodeDeptId);
			try {
				String jsonResult = UrlConnUtils.getUrlConn(getUrl);
				JSONObject jsonObject = JSONObject.fromObject(jsonResult);
				_log.info(jsonObject);

				JSONArray jsonArray = JSONArray.fromObject(jsonObject
						.get("department"));
				for (Object obj : jsonArray) {
					JSONObject dept = JSONObject.fromObject(obj);

					TblCustomorganization organization = new TblCustomorganization();
					organization.setCorpid(corpinfo.getCorpid());
					organization.setOrgid(dept.getInt("id"));
					organization.setName(dept.getString("name"));
					organization.setParentid(dept.getInt("parentid"));
					organization.setOrder(dept.getInt("order"));

					try {
						// 本地库保存组织架构(存在UPDATE、不存在INSERT)
						if (organizationBiz.countBySelective(organization) > 0) {
							organizationBiz.updateSelective(organization);
						} else {
							organizationBiz.saveSelective(organization);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				_log.info(e);
			}
		}

		_log.info("WxDeptJob定时程序结束:syncDept");
	}

	/**
	 * 企业号线上通讯录组织架构删除
	 */
	public void delDept() {
		_log.info("WxDeptJob定时程序启用:delDept");
		// 获取所有企业号信息
		List<TblCorpinfo> listCorpInfo = corpInfoBiz.getAll();
		for (TblCorpinfo corpinfo : listCorpInfo) {

			_log.info("进入企业号【" + corpinfo.getCorpname() + "】进行同步用户");

			// 获取根节点下的组织结构
			String getUrl = MessageFormat.format(WxCorpApiConstant.Get_Dept_URL,
					corpinfo.getAccesstoken(), WxCorpApiConstant.RootNodeDeptId);
			try {
				String jsonResult = UrlConnUtils.getUrlConn(getUrl);
				JSONObject jsonObject = JSONObject.fromObject(jsonResult);

				_log.info(jsonObject);

				JSONArray jsonArray = JSONArray.fromObject(jsonObject
						.get("department"));
				Set<Integer> set = new HashSet<Integer>();

				// 父节点去重存储
				for (Object obj : jsonArray) {
					JSONObject dept = JSONObject.fromObject(obj);
					set.add(dept.getInt("parentid"));
				}
				Object[] parentId = set.toArray();
				// 升序排序
				Arrays.sort(parentId);

				// 处理线上组织架构删除
				for (int i = parentId.length - 1; i > 0; i--) {

					List<TblCustomorganization> listDept = organizationBiz
							.listCustomorganization(corpinfo.getCorpid(),
									Integer.valueOf(parentId[i].toString()));
					for (TblCustomorganization dept : listDept) {
						// 线上删除组织
						String url = MessageFormat.format(
								WxCorpApiConstant.Delete_Dept_URL, corpinfo
										.getAccesstoken(), dept.getOrgid()
										.toString());
						UrlConnUtils.getUrlConn(url);
						// 本地库删除对应组织
						organizationBiz.delBySelective(dept);
					}
				}
			} catch (IOException e) {
				_log.info(e);
			}

		}
		_log.info("WxDeptJob定时程序结束:delDept");
	}
}
