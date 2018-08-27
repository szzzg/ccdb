package com.movitech.ws;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movitech.bean.UserBean;

import net.sf.json.JSONObject;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年8月8日上午11:10:24
 * @author: 周志刚
 * @ClassName: RestfulApi
 * @Description: TODO 1.@RestController = @Controller + @ResponseBody
 *               2.post请求参数必须@RequestBody接收获取，否则获取不到
 *               3.<mvc:annotation-driven />注解驱动
 *               自动开启DefaultAnnotationHandlerMapping、AnnotationMethodHandlerAdapter
 */
@RestController
@RequestMapping("/api")
public class RestfulApi {
	@RequestMapping(value = "/sayHi/{token}", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String sayHi(@PathVariable String token) {
		return "this is " + token;
	}

	@RequestMapping(value = "/sayHello/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String sayHello(@PathVariable String token) {
		return "this is " + token;
	}

	@RequestMapping(value = "/receiveJsonToStr", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String receiveJsonToStr(@RequestBody JSONObject jsonObj) {
		return jsonObj.toString();
	}

	@RequestMapping(value = "/receiveJson", method = RequestMethod.POST)
	public JSONObject receiveJson(@RequestBody JSONObject jsonObj) {
		return jsonObj;
	}

	@RequestMapping(value = "/receiveJsonToken/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String receiveJson(@PathVariable String token) {
		return token;
	}

	@RequestMapping(value = "/receiveJson/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String receiveJson(@PathVariable String token, @RequestBody JSONObject jsonObj) {
		return token + ">>>>" + jsonObj;
	}

	/**
	 *
	 * @param token
	 * @param userBean
	 * @return
	 * 
	 * 		TODO REST接口 @RequestBody UserBean接收 json自动装换成bean对象
	 *         前提是需要在spring-mvc.xml中配置数据转换器AnnotationMethodHandlerAdapter
	 *         注：(友好度比较差，不建议使用)
	 */
	@RequestMapping(value = "/receiveObj/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String receiveObj(@PathVariable String token, @RequestBody UserBean userBean) {
		return token + ">>>>" + userBean.getUsername() + ">>>>" + userBean.getPassword();
	}

	@RequestMapping(value = "/receiveObj1/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String receiveObj1(@PathVariable String token, UserBean userBean) {
		return token + ">>>>" + userBean.getUsername() + ">>>>" + userBean.getPassword();
	}

	@RequestMapping(value = "/receiveObjReturnJson/{token}", method = RequestMethod.POST)
	public JSONObject receiveObjReturnJson(@PathVariable String token, UserBean userBean) {
		return JSONObject.fromObject(userBean);
	}

	@RequestMapping(value = "/receiveObjReturnObj/{token}", method = RequestMethod.POST)
	public UserBean receiveObjReturnObj(@PathVariable String token, UserBean userBean) {
		return userBean;
	}

	/**
	 * 
	 * @param token
	 * @param username
	 * @return
	 * 
	 * 		TODO @RequestBody 接收的是请求的所有参数
	 */
	@RequestMapping(value = "/receiveStr/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String receiveStr(@PathVariable String token, @RequestBody String username) {
		try {
			String name = new String(token.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return token + ">>>>" + username + "张三";
	}

	/**
	 * 
	 * @param token
	 * @param username
	 * @return
	 * 
	 * 		TODO 不带@RequestBody 接收的是请求的所有参数中username参数的值
	 */
	@RequestMapping(value = "/receiveStr1/{token}", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String receiveStr1(@PathVariable String token, String username) {
		return token + ">>>>" + username + "张三";
	}
}
