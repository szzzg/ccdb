package com.movitech.testcase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movitech.service.MyService;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年9月12日上午9:57:02
 * @author: 周志刚
 * @ClassName: TestAOPCace
 * @Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAOPCace {

	/**
	 * 
	 * 1.@Autowired 注解单独使用：是按照类型（byType）装配依赖对象
	 * 2.@Autowired和@Qualifier("myService")一起使用：按照名称（byName）来装配====>和@Resource等效
	 * 3.@Resource默认按照byName自动注入
	 * 
	 */
	@Autowired
	@Qualifier("myService")
//	@Resource
	private MyService myService;

	@Test
	public void testAopService() {

		myService.sayHi();

		System.out.println(myService.recordOrder("笔记本电脑", 66));

	}
}
