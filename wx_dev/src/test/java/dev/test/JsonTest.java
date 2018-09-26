package dev.test;

import java.util.Hashtable;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ProjectName: wx_dev
 * @version create time：2016年12月23日下午4:24:29
 * @author: 周志刚
 * @ClassName: JsonTest
 * @Description: TODO
 */
public class JsonTest {

	public static void main(String[] args) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "员工");
		jsonObject.put("value", "001");
		jsonObject.put("name", "验证信息");
		jsonObject.put("value", "00001");
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("name", "员工");
		jsonObject1.put("value", "002");
		jsonObject1.put("name", "验证信息");
		jsonObject1.put("value", "00002");
		System.out.println(jsonObject.toString());
		System.out.println(jsonObject1.toString());
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject1);
		System.out.println(jsonArray.toString());
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("attrs", jsonArray.toString());
		System.out.println(jsonObj.toString());
		
		
//		String str = "abc1234567";
//		
//		System.out.println(str.substring(str.length()- 6));
//		
//		
//		
//		Map<String, String> map = new Hashtable<String, String>();
//		map.put("Danone Nutricia Early Life Nutrition (Hong Kong) Limited", "ELN HK");
//		map.put("Danone Nutricia Online Distribution Hong Kong LTD.", "ELN Online Distribution HK");
//		map.put("Accounts Receivable & Receivables Collection", "AR & Receivables Collection");
//		map.put("CBS Finance Planning & Business Controlling", "CBS FP & Business Control");
//		map.put("Sales Operations & Trade Marketing", "Sales Operations & Trade Mkt");
//		
//		System.out.println(map.get("Sales Operations & Trade Marketing")==null?"Sales Operations & Trade Marketing1":map.get("Sales Operations & Trade Marketing"));
	}
}
