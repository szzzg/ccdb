package com.movitech.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movitech.bean.UserBean;

import net.sf.json.JSONObject;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年8月8日上午10:33:26
 * @author: 周志刚
 * @ClassName: RestfulApiController
 * @Description: TODO
 */
@Controller
@RequestMapping("/rest")
public class RestfulApiController {

	@ResponseBody
	@RequestMapping(value = "/sayHi/{token}", method = RequestMethod.GET)
	public String sayHi(@PathVariable String token) {
		return "this is " + token;
	}

	@ResponseBody
	@RequestMapping(value = "/sayHello/{token}", method = RequestMethod.POST)
	public String sayHello(@PathVariable String token) {
		return "this is " + token;
	}

	@ResponseBody
	@RequestMapping(value = "/receiveJsonToStr", method = RequestMethod.POST)
	public String receiveJsonToStr(@RequestBody JSONObject jsonObj) {
		return jsonObj.toString();
	}

	@ResponseBody
	@RequestMapping(value = "/receiveJson", method = RequestMethod.POST)
	public JSONObject receiveJson(@RequestBody JSONObject jsonObj) {
		return jsonObj;
	}

	@ResponseBody
	@RequestMapping(value = "/receiveJsonToken/{token}", method = RequestMethod.POST)
	public String receiveJson(@PathVariable String token) {
		return token;
	}

	@ResponseBody
	@RequestMapping(value = "/receiveJson/{token}", method = RequestMethod.POST)
	public String receiveJson(@PathVariable String token, @RequestBody JSONObject jsonObj) {
		return token + ">>>>" + jsonObj;
	}

	@ResponseBody
	@RequestMapping(value = "/receiveObj/{token}", method = RequestMethod.POST)
	public String receiveObj(@PathVariable String token, @RequestBody UserBean userBean) {
		return token + ">>>>" + userBean.getUsername() + ">>>>" + userBean.getPassword();
	}

	@ResponseBody
	@RequestMapping(value = "/receiveObj1/{token}", method = RequestMethod.POST)
	public String receiveObj1(@PathVariable String token, UserBean userBean) {
		return token + ">>>>" + userBean.getUsername() + ">>>>" + userBean.getPassword();
	}

	@ResponseBody
	@RequestMapping(value = "/receiveStr/{token}", method = RequestMethod.POST)
	public String receiveStr(@PathVariable String token, @RequestBody String userBean) {
		return token + ">>>>" + userBean;
	}

	@ResponseBody
	@RequestMapping(value = "/receiveStr1/{token}", method = RequestMethod.POST)
	public String receiveStr1(@PathVariable String token, String userBean) {
		return token + ">>>>" + userBean;
	}

}
