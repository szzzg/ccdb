package com.movitech.aop;
/** 
 * @ProjectName: restful-api-spring
 * @version create time：2018年9月12日下午3:28:01
 * @author: 周志刚
 * @ClassName: SimpleAOP
 * @Description: TODO
 */
public class SimpleAOP {

	
	public void beformDLL() {
		System.out.println("执行开始。。。。。");
	}
	
	public void afterDLL() {
		System.out.println("执行结束。。。。。");
	}
}
