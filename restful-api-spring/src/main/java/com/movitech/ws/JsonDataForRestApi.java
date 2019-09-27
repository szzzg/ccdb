package com.movitech.ws;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年12月7日下午3:35:02
 * @author: 周志刚
 * @ClassName: JsonDataForRestApi
 * @Description: TODO
 */
@RestController
@RequestMapping("/json-data-api")
public class JsonDataForRestApi {

	@GetMapping("/load-init-data")
	public JSONObject loadInitData() throws IOException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", "001");
		jsonObj.put("name", "张三");
		jsonObj.put("sex", "男");
		jsonObj.put("age", "28");
		jsonObj.put("job", "IT");

		return jsonObj;
	}
}
