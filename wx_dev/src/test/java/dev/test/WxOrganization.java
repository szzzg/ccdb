package dev.test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.wx.dev.biz.CustomorganizationBiz;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.entity.TblCustomorganization;
import com.wx.dev.util.UrlConnUtils;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月2日下午1:38:56
 * @author: 周志刚
 * @ClassName: WxOrganization
 * @Description: 删除组织架构
 */
public class WxOrganization {

	public static void main(String[] args) {

//		String accessToken = "sqX2wJyl0aBoYdR2uYBirICSIf1uV0dqM_RBJYkC23LanIqpKbPHtvHVN50CbgXFWYD5QD_B1v2L755iAAZD91s1NrcAQlSLPtHWfMYwicRvScAPn4UsRbxxLfb56eG29Z2tuAtqxY-XADqBdW8NTt2KUL9J_a9wkQNYLhUYTQQPbX8_1vY9FzPTtu5mYlfOW1zks0CNxTFIRDYe0m7WH5ceg3wD-45hkagpOk24v1hNw9olgpzNhzHjk1coUHAAQwwrLzarmQKquvQtLtZqex1lbo9kIvdZf1awABSW6SM";
//		String corpId = "wxe2701fbfb3c1936d";
		String accessToken = "Wmqkp-eXjZ8vgvbx5Cakrlg4wq9eO2v5ZbtYFt02mM4lnM4USSnNlzU0kAYWYGXdOxK2MCnAY_sHxbd3JxRIT3n7FybFvz8LhJ2b0lVbPRnbzNUg3TNbk1PIkTGN05wkLepQ-kEDxvLRWESI8Z4U_SpSF1GbcRNYKgRzP7DToJuUxDJqHqi7HKuz8sk2WG7aLWU5zYsutncjKSBCORz48MAqjm2wSLMTEKA7QNkB1xbyirou2JhKR0GdBFaEUWgyB30ka3P4_w9xFo0Zxy79ZzpjlfYbi9ZplR0_YXr2qXI";
		String corpId = "wx0fb1e39f79174fd2";
//		String accessToken = "_YZHA7KB_xp2LJmwEvUrnjTtx_oAHd0ooD1L0dq4z9EmxjgvTJ5z3uJr-2lnh__JFgOeLHOVZvQtVVARMHCCeZ5smKK8dfSHqkzDlj8FaSUemhLEjtmnSef-cb6BIFgMYFAEr7vI46EKsSgINlzsAxqTMKn752fP3H780t3lfJhavBHrEd4ApwsmJMNyj_f25t1CL-zyAVgdMMxrzaIc0NcblNO8Tt2EK6I452OxAvN9loQs99bYrPb5MCNzZrweOmTT_eN9sZFs7lSKxcDuWi9E0xOmH_pYUVCrtI2atFM";
//		String corpId = "wxe3489563252df116";

		String getUrl = MessageFormat.format(WxCorpApiConstant.Get_Dept_URL,
				accessToken, "1");
		
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		CustomorganizationBiz organizationBiz = (CustomorganizationBiz) beanFactory
				.getBean("customorganizationBiz");

		try {
			String jsonResult = UrlConnUtils.getUrlConn(getUrl);

			JSONObject jsonObject = JSONObject.fromObject(jsonResult);
			System.out.println(jsonObject);

			JSONArray jsonArray = JSONArray.fromObject(jsonObject
					.get("department"));
			System.out.println(jsonArray);

			Set<Integer> set = new HashSet<Integer>();
			for (Object obj : jsonArray) {
				JSONObject dept = JSONObject.fromObject(obj);
				set.add(dept.getInt("parentid"));

				TblCustomorganization organization = new TblCustomorganization();
				organization.setCorpid(corpId);
				organization.setOrgid(dept.getInt("id"));
				organization.setName(dept.getString("name"));
				organization.setParentid(dept.getInt("parentid"));
				organization.setOrder(dept.getInt("order"));

				try {
					organizationBiz.saveSelective(organization);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			Object[] parentId = set.toArray();
			// 升序排序
			Arrays.sort(parentId);
			System.out.println(parentId);

			// 处理线上组织架构删除
			for (int i = parentId.length - 1; i > 0; i--) {
				System.out.println("parentId>>>>" + parentId[i]);

				List<TblCustomorganization> listDept = organizationBiz
						.listCustomorganization(corpId,
								Integer.valueOf(parentId[i].toString()));
				for (TblCustomorganization dept : listDept) {

//					if ("wxe3489563252df116".equals(corpId)) {
//						if (dept.getOrgid() == 8 || dept.getOrgid() == 9
//								|| dept.getOrgid() == 10
//								|| dept.getOrgid() == 11
//								|| dept.getOrgid() == 12
//								|| dept.getOrgid() == 13) {
//							continue;
//						}
//					}
//					if ("wx0fb1e39f79174fd2".equals(corpId)) {
//						if (dept.getOrgid() == 97 || dept.getOrgid() == 98
//								|| dept.getOrgid() == 99
//								|| dept.getOrgid() == 100) {
//							continue;
//						}
//					}
//					if("wx0fb1e39f79174fd2".equals(corpId)){
//						if (dept.getOrgid() == 97||dept.getOrgid() == 98||dept.getOrgid() == 99||dept.getOrgid() == 100){
//							continue;
//						}
//					}
					if("wxe3489563252df116".equals(corpId)){
						if (dept.getOrgid() == 914||dept.getOrgid() == 915||dept.getOrgid() == 916||dept.getOrgid() == 917||dept.getOrgid() == 918||dept.getOrgid() == 919){
							continue;
						}
					}
					// 调用微信接口
					String url = MessageFormat.format(
							WxCorpApiConstant.Delete_Dept_URL, accessToken,
							dept.getOrgid().toString());
					UrlConnUtils.getUrlConn(url);

					// 本地库删除对应组织
					organizationBiz.delBySelective(dept);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
