package com.movitech.service;

import org.springframework.stereotype.Service;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年9月12日上午9:38:35
 * @author: 周志刚
 * @ClassName: MyService
 * @Description: TODO
 */
@Service
public class MyService {

	public void sayHi() {
		System.out.println("hello world service!");
	}

	public String recordOrder(String orderName, int num) {
		return "系统记录：订单名称" + orderName + ",一共" + num + "件!";
	}
}
