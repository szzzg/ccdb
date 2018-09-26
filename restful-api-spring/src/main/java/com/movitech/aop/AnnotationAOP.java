package com.movitech.aop;

import org.aspectj.lang.JoinPoint;
//import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2018年9月12日上午9:41:13
 * @author: 周志刚
 * @ClassName: AnnotationAOP
 * @Description: TODO
 */
@Component
@Aspect
public class AnnotationAOP {

	@Pointcut("execution(* com.movitech.service.*.*(..))")
	public void pointCutName() {
	}

	@Before(value = "pointCutName()")
	public void beform(JoinPoint joinpoint) {
		Class<?> clazz = joinpoint.getTarget().getClass(); // 获取被切入的类
//		Class clazz = joinpoint.getClass(); //获取JoinPoint当前类

		System.out.println(clazz.getName());

		System.out.println("beform。。。。。");
	}

	@After(value = "pointCutName()")
	public void after() {
		System.out.println("after。。。。。");
	}

}
