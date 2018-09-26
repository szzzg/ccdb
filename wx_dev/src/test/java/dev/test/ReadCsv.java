package dev.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.dev.biz.CustomorganizationBiz;
import com.wx.dev.biz.CustomuserBiz;
import com.wx.dev.biz.DeptCsvDataBiz;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.data.DepartmentItem;
import com.wx.dev.entity.TblCustomorganization;
import com.wx.dev.entity.TblCustomuser;
import com.wx.dev.entity.TblDeptcsvdata;
import com.wx.dev.util.ConstantUtilCsv;
import com.wx.dev.util.UrlConnUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月22日下午3:24:28
 * @author: 周志刚
 * @ClassName: ReadCsv
 * @Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ReadCsv {

	Log _log = LogFactory.getLog(ReadCsv.class);

	@Resource
	private DeptCsvDataBiz csvDataBiz;
	@Resource
	private CustomorganizationBiz customorganizationBiz;
	@Resource
	private CustomuserBiz customuserBiz;

	String accessToken = "";

	// @Test
	public void readDepartment() throws IOException {

		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				"D:/HRDepartment.csv"));// 字符流
		BufferedReader br = new BufferedReader(isr);// 缓冲流
		String str = null;
		int line = 0;
		int code = 0;
		int cbuCode = 0;
		int nameZH = 0;

		try {
			while ((str = br.readLine()) != null) {
				// CSV头部信息
				String dept[] = str.replaceAll("\"", "").split(",");

				if (line > 0) {
					// 读取内容
					System.out.println(dept[code] + ">>>>" + dept[cbuCode]
							+ ">>>>" + dept[nameZH]);

					TblDeptcsvdata deptcsvdata = new TblDeptcsvdata();
					deptcsvdata.setCode(dept[code].toUpperCase());
					deptcsvdata.setCbu(dept[cbuCode].toUpperCase());
					deptcsvdata.setName(dept[nameZH].toUpperCase());
					if (csvDataBiz.countSelectByCondition(deptcsvdata) == 0) {
						try {
							_log.info("插入数据");
							csvDataBiz.saveSelective(deptcsvdata);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} else {
						_log.info("数据已存在");
					}
				} else {
					// 读取标题
					for (int j = 0; j < dept.length; j++) {
						if (ConstantUtilCsv.CSV_DEPT_TITLE_Code.equals(dept[j])) {
							code = j;
						} else if (ConstantUtilCsv.CSV_DEPT_TITLE_SBUCode
								.equals(dept[j])) {
							cbuCode = j;
						} else if (ConstantUtilCsv.CSV_DEPT_TITLE_NameZH
								.equals(dept[j])) {
							nameZH = j;
						}
					}
					System.out.println(dept[code] + ">>>>" + dept[cbuCode]
							+ ">>>>" + dept[nameZH]);
				}
				line++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readEmployee() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(
				"D:/Employee.csv"));// 字符流
		BufferedReader br = new BufferedReader(isr);// 缓冲流
		String str = null;
		int line = 0;
		int code = 0, cName = 0, cbuCode = 0, mobile = 0, serviceStatus = 0, mail = 0, depL1 = 0, depL2 = 0, depL3 = 0, depL4 = 0, depL5 = 0;

		Map<String, String> map = new Hashtable<String, String>();
		map.put(ConstantUtilCsv.CORPNAME, "wx0fb1e39f79174fd2");

		// Department文件中所有企业号中的组织架构
		Map<String, String> mapDept = new Hashtable<String, String>();
		// TODO
		List<TblDeptcsvdata> dataList = csvDataBiz.getAll();
		for (TblDeptcsvdata obj : dataList) {
			mapDept.put(obj.getCode(), obj.getName());
		}

		String collectCorpId = "wxe3489563252df116";

		Map<String, Integer> mapOrg = new Hashtable<String, Integer>();
		// TODO 第一层组织架构
		List<TblCustomorganization> listOrg = customorganizationBiz
				.getAll(collectCorpId);
		for (TblCustomorganization org : listOrg) {
			mapOrg.put(org.getName().toUpperCase(), org.getOrgid());
		}

		while ((str = br.readLine()) != null) {

			// CSV头部信息
			String employee[] = str.replaceAll("\"", "").split(",");

			if (line > 0) {

				// 获取用户的组织
				String orgs = "";
				TblCustomuser customUser = new TblCustomuser();

				// CBU满足DUMEX,向NELN企业号同步
				if (ConstantUtilCsv.CORPNAME.equals(employee[cbuCode]
						.toUpperCase())) {
					TblCustomorganization org1 = new TblCustomorganization();
					TblCustomorganization org2 = new TblCustomorganization();
					TblCustomorganization org3 = new TblCustomorganization();
					TblCustomorganization org4 = new TblCustomorganization();
					TblCustomorganization org5 = new TblCustomorganization();
					// 一层架构
					if (StringUtils.isNotEmpty(employee[depL1])) {
						String d1 = mapDept.get(employee[depL1]);
						org1.setName(d1);
						org1.setCorpid(collectCorpId);
						if (customorganizationBiz.countBySelective(org1) == 0) {
							org1.setParentid(1);
							org1.setOrgid(customorganizationBiz
									.getMaxOrgId(org1) + 1);
							try {
								customorganizationBiz.saveSelective(org1);

								// 推送微信企业号
								String postUrl = MessageFormat.format(
										WxCorpApiConstant.Create_Dept_URL,
										accessToken);

								DepartmentItem item = new DepartmentItem();
								item.setName(org1.getName());
								item.setParentid(org1.getParentid().toString());
								item.setId(org1.getId().toString());
								UrlConnUtils.postUrlConn(postUrl, JSONObject
										.fromObject(item).toString());
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						orgs = "1" + "," + org1.getOrgid();
					}
					// 二层架构
					if (StringUtils.isNotEmpty(employee[depL2])) {
						orgs = extractedDept(depL2, mapDept, collectCorpId,
								employee, orgs, org1, org2);
					}
					// 三层架构
					if (StringUtils.isNotEmpty(employee[depL3])) {
						orgs = extractedDept(depL3, mapDept, collectCorpId,
								employee, orgs, org2, org3);
					}
					// 四层架构
					if (StringUtils.isNotEmpty(employee[depL4])) {
						orgs = extractedDept(depL4, mapDept, collectCorpId,
								employee, orgs, org3, org4);
					}
					// 五层架构
					if (StringUtils.isNotEmpty(employee[depL5])) {
						orgs = extractedDept(depL5, mapDept, collectCorpId,
								employee, orgs, org4, org5);
					}

					// 用户信息添加
					customUser.setCorpid(collectCorpId);
					customUser.setUserid(employee[code]);
					customUser.setName(employee[cName]);
					customUser.setDepartment(orgs);
					customUser.setMobile(employee[mobile].trim().replaceAll(
							" ", ""));
					customUser.setEmail(employee[mail]);

					JSONObject postData = new JSONObject();
					postData.put("userid", customUser.getUserid());
					postData.put("name", customUser.getName());
					postData.put("department", customUser.getDepartment());
					postData.put("position", customUser.getPosition());
					postData.put("mobile", customUser.getMobile());
					postData.put("gender", customUser.getGender());
					if (StringUtils.isNotEmpty(customUser.getEmail())) {
						postData.put("email", customUser.getEmail());
					}
					if (StringUtils.isNotEmpty(customUser.getWeixinid())) {
						postData.put("weixinid", customUser.getWeixinid());
					}

					JSONArray jsonArray = new JSONArray();
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("员工号", customUser.getUserid());
					jsonObj.put("验证信息", customUser.getEmail());
					jsonArray.add(jsonObj);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("attrs", jsonArray.toString());

					postData.put("extattr", jsonObject.toString());

					// TODO 根据EmployeeCode判定用户是否存在
					if (customuserBiz.countSelectByUserId(customUser) > 0) {

						if("0".equals(employee[serviceStatus].trim())){
							postData.put("enable", 0);
						}

						System.out.println(postData.toString());
						String postUrl = MessageFormat.format(
								WxCorpApiConstant.Update_User_URL, accessToken);
						UrlConnUtils.postUrlConn(postUrl, postData.toString());
						try {
							customuserBiz.updateSelective(customUser);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} else {
						jsonObject.put("attrs", jsonArray.toString());

						postData.put("extattr", jsonObject.toString());
						System.out.println(postData.toString());
						String postUrl = MessageFormat.format(
								WxCorpApiConstant.Create_User_URL, accessToken);
						UrlConnUtils.postUrlConn(postUrl, postData.toString());
						try {
							customuserBiz.saveSelective(customUser);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}

				}
				TblCustomorganization org1 = new TblCustomorganization();
				TblCustomorganization org2 = new TblCustomorganization();
				TblCustomorganization org3 = new TblCustomorganization();
				TblCustomorganization org4 = new TblCustomorganization();
				TblCustomorganization org5 = new TblCustomorganization();
				// 一层架构
				if (StringUtils.isNotEmpty(employee[depL1])) {
					String d1 = mapDept.get(employee[depL1]);
					org1.setName(d1);
					org1.setCorpid(collectCorpId);
					if (customorganizationBiz.countBySelective(org1) == 0) {
						org1.setParentid(mapOrg.get(employee[cbuCode]));
						org1.setOrgid(customorganizationBiz.getMaxOrgId(org1) + 1);
						try {
							customorganizationBiz.saveSelective(org1);

							// 推送微信企业号
							String postUrl = MessageFormat.format(
									WxCorpApiConstant.Create_Dept_URL,
									accessToken);

							DepartmentItem item = new DepartmentItem();
							item.setName(org1.getName());
							item.setParentid(org1.getParentid().toString());
							item.setId(org1.getId().toString());
							UrlConnUtils.postUrlConn(postUrl, JSONObject
									.fromObject(item).toString());
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					orgs = "1" + "," + org1.getParentid() + ","
							+ org1.getOrgid();
				}
				// 二层架构
				if (StringUtils.isNotEmpty(employee[depL2])) {
					orgs = extractedDept(depL2, mapDept, collectCorpId,
							employee, orgs, org1, org2);
				}
				// 三层架构
				if (StringUtils.isNotEmpty(employee[depL3])) {
					orgs = extractedDept(depL3, mapDept, collectCorpId,
							employee, orgs, org2, org3);
				}
				// 四层架构
				if (StringUtils.isNotEmpty(employee[depL4])) {
					orgs = extractedDept(depL4, mapDept, collectCorpId,
							employee, orgs, org3, org4);
				}
				// 五层架构
				if (StringUtils.isNotEmpty(employee[depL5])) {
					orgs = extractedDept(depL5, mapDept, collectCorpId,
							employee, orgs, org4, org5);
				}

				// 用户信息添加
				customUser.setCorpid(collectCorpId);
				customUser.setUserid(employee[code].substring(employee[code]
						.length() - 6));// TODO DAPM用户账号是身份证去后6位
				customUser.setName(employee[cName]);
				customUser.setDepartment(orgs);
				customUser.setMobile(employee[mobile]);
				customUser.setEmail(employee[mail]);

				JSONObject postData = new JSONObject();
				postData.put("userid", customUser.getUserid());
				postData.put("name", customUser.getName());
				postData.put("department", customUser.getDepartment());
				postData.put("position", customUser.getPosition());
				postData.put("mobile", customUser.getMobile());
				postData.put("gender", customUser.getGender());
				if (StringUtils.isNotEmpty(customUser.getEmail())) {
					postData.put("email", customUser.getEmail());
				}
				if (StringUtils.isNotEmpty(customUser.getWeixinid())) {
					postData.put("weixinid", customUser.getWeixinid());
				}

				JSONArray jsonArray = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("员工号", customUser.getUserid());
				jsonObj.put("验证信息", customUser.getEmail());
				jsonArray.add(jsonObj);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("attrs", jsonArray.toString());

				postData.put("extattr", jsonObject.toString());

				if (customuserBiz.countSelectByUserId(customUser) > 0) {

					postData.put("enable", 1);

					System.out.println(postData.toString());
					String postUrl = MessageFormat.format(
							WxCorpApiConstant.Update_User_URL, accessToken);

					UrlConnUtils.postUrlConn(postUrl, postData.toString());
					try {
						customuserBiz.updateSelective(customUser);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(postData.toString());
					String postUrl = MessageFormat.format(
							WxCorpApiConstant.Create_User_URL, accessToken);
					UrlConnUtils.postUrlConn(postUrl, postData.toString());
					try {
						customuserBiz.saveSelective(customUser);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			} else {
				// 读取标题
				for (int j = 0; j < employee.length; j++) {
					if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_Code
							.equals(employee[j])) {
						code = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_C_Name
							.equals(employee[j])) {
						cName = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_Mobile
							.equals(employee[j])) {
						mobile = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_CBU_Code
							.equals(employee[j])) {
						cbuCode = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_ServiceStatus
							.equals(employee[j])) {
						serviceStatus = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_CompanyEmailAddress
							.equals(employee[j])) {
						mail = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_PT_DepL1
							.equals(employee[j])) {
						depL1 = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_PT_DepL2
							.equals(employee[j])) {
						depL2 = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_PT_DepL3
							.equals(employee[j])) {
						depL3 = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_PT_DepL4
							.equals(employee[j])) {
						depL4 = j;
					} else if (ConstantUtilCsv.CSV_EMPLOYEE_TITLE_PT_DepL5
							.equals(employee[j])) {
						depL5 = j;
					}
				}
			}
			line++;
		}
		br.close();
	}

	/**
	 * 节点部门添加
	 * 
	 * @param depL2
	 * @param mapDept
	 * @param collectCorpId
	 * @param employee
	 * @param orgs
	 * @param org1
	 * @param org2
	 * @return
	 * @throws IOException
	 */
	public String extractedDept(int depL2, Map<String, String> mapDept,
			String collectCorpId, String[] employee, String orgs,
			TblCustomorganization org1, TblCustomorganization org2)
			throws IOException {
		String d2 = mapDept.get(employee[depL2]);
		org2.setName(d2);
		org2.setCorpid(collectCorpId);
		org2.setParentid(org1.getOrgid());
		if (customorganizationBiz.countBySelective(org2) == 0) {
			org2.setOrgid(customorganizationBiz.getMaxOrgId(org2) + 1);
			try {
				customorganizationBiz.saveSelective(org2);
				// 推送微信企业号
				String postUrl = MessageFormat.format(
						WxCorpApiConstant.Create_Dept_URL, accessToken);

				DepartmentItem item = new DepartmentItem();
				item.setName(org2.getName());
				item.setParentid(org2.getParentid().toString());
				item.setId(org2.getId().toString());
				UrlConnUtils.postUrlConn(postUrl, JSONObject.fromObject(item)
						.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		orgs += org2.getOrgid();
		return orgs;
	}
}
