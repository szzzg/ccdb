package com.movitech.annotation.service;

import org.springframework.stereotype.Service;

import com.movitech.aop.annotation.Person;
import com.movitech.aop.annotation.PersonSex;
import com.movitech.bean.UserBean;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2019年9月27日上午10:25:56
 * @author: 周志刚
 * @ClassName: AnnService
 * @Description: TODO
 */
@Service
public class AnnService {

	@Person(value = "个人信息", name = "{#nameArg}", sex = PersonSex.MAN)
	public void annotationService(String nameArg) {

		System.out.println("测试自动注解aop拦截方法");
	}
	
	@Person(value = "个人信息", name = "{#bean.username}", sex = PersonSex.MAN)
	public void annotationTypeService(UserBean bean) {
		System.out.println("测试自动注解aop拦截方法2");
	}
}
