package com.movitech.util;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年8月9日下午2:13:50
 * @author: 周志刚
 * @ClassName: ConfigDemo
 * @Description: TODO
 */
public class ConfigDemo {

	public static String str = "";
	public static final String str1 = "qwqwqqw";
	public static volatile String str2 = ""; // volatile关键字 适合做动态常量（如：配置文件信息），可重复操作值，可以避免些数据库的配置
	public String str3 = "sdfsdfds";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigDemo demo = new ConfigDemo();
		str = "1111";
		str2 = "asdasdasda";
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(demo.str3);
		System.out.println("----------------------------");
		System.gc();
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(demo.str3);
		System.out.println("----------------------------");

		str = "22222";
		str2 = "koc1koc2";
		demo.str3 = "hello word";
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(demo.str3);
		System.out.println("----------------------------");
	}

}
