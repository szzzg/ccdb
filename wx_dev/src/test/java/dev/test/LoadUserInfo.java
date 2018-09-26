package dev.test;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//import com.sun.tools.javah.resources.l10n;
import com.wx.dev.constant.WxCorpApiConstant;
import com.wx.dev.util.UrlConnUtils;

/** 
 * @ProjectName: wx_dev
 * @version create time：2017年9月7日下午3:22:35
 * @author: 周志刚
 * @ClassName: LoadUserInfo
 * @Description: TODO
 */
public class LoadUserInfo {

	public static void main(String[] args) throws IOException {
//		String token = "H6VI6d9_GsTdf4jT4RAb9i1C_jrR_oPkiUDkpsaf6GsLgG3uQkdqrbYHM8qzKttKsadF-AYijDdI5sylabc3K3HOUWFT8jok9SYVyJ8GilAOMWiAJRuOjMerpj8dHbXUeoAmc-Z_n-U6MdhE1HX7LTkQml_wNCG1t_NHjetFvN8y2w0O-7c2RufBGlJvqAqztoVGvFgAOy3ygOsnNzhiN7k9MCTrweeBPM4W9GyiSgmXS7YnE0VV_B3OvNmZK3i1pOy9QPz6ypKwB0r3EqmSHtIA-fm__XPZgrTRGYVXW_M";
//		String corpId = "wx8c4e63af577f33a9";
//		String corpSecret = "_fUGDjprqXqfxiUYTLx2f4YLV4HawWlBDG44yymEw5PcP1joaGL6kDSvFR9997nd";
//		
//		String url = MessageFormat.format(WxCorpApiConstant.Get_DeptUser_URL_NEW, token,1,1);
//		
//		String json = UrlConnUtils.getUrlConn(url);
//		JSONObject jsonObject = JSONObject.fromObject(json);
//		JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("userlist"));
//		for (Object object : jsonArray) {
//			JSONObject jObject = JSONObject.fromObject(object);
//			System.out.println(jObject.getString("userid") + ">>>>" +jObject.getString("department"));
//		}
		
		
//		String orgs = "1,44,5,52";
//		String org[] = orgs.split(",");
//		int[] numOrg = stringToInt(org);
//		Arrays.sort(numOrg);
//		StringBuffer sb = new StringBuffer("");
//		for (int i = 0; i < numOrg.length; i++) {
//			sb.append(numOrg[i] + ",");
//		}
//		System.out.println(sb.substring(0, sb.length() - 1));
//		System.out.println(org[org.length - 1]);
//		
//		int[] a = new int[]{1,44,5,52};
//		Arrays.sort(a);
//		for(int i=0;i<a.length;i++)
//		System.out.println(a[i]+"  ");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		Date endDate = cal.getTime();
		cal.add(Calendar.DATE, -1 * 6);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date startDate = cal.getTime();
		System.out.println(startDate + " >>>>>>" + endDate);
	}
	
	
	public static int[] stringToInt(String[] arrs) {
		int[] ints = new int[arrs.length];
		for (int i = 0; i < arrs.length; i++) {
			ints[i] = Integer.parseInt(arrs[i]);
		}
		return ints;
	}
}
