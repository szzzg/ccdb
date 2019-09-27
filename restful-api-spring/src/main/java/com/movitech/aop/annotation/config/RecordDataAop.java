package com.movitech.aop.annotation.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import com.movitech.aop.annotation.Person;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2019年9月27日上午10:04:57
 * @author: 周志刚
 * @ClassName: RecordDataAop
 * @Description: TODO
 */
@Aspect
@Component
public class RecordDataAop {

	@Pointcut("@annotation(com.movitech.aop.annotation.Person)")
	public void pcn() {
	}

	@Before(value = "pcn()")
	public void beform(JoinPoint joinpoint) {
		Class<?> clazz = joinpoint.getTarget().getClass(); // 获取被切入的类
//		Class clazz = joinpoint.getClass(); //获取JoinPoint当前类

		System.out.println(clazz.getName());

		System.out.println("beform。。。。。");
	}

	/**
	 * 第一种方式(SpEL表达式取不到值)
	 * 
	 * @param joinpoint
	 * @param person
	 */
//	@Around(value = "pcn() && @annotation(person)", argNames = "person")
//	public void around(JoinPoint joinpoint, Person person) {
//
//		System.out.println(person.sex());
//		System.out.println(person.value());
//		System.out.println(person.name());
//
//	}

	/**
	 * 第二种方式
	 * 
	 * @param joinpoint
	 * @param person
	 */
	@Around(value = "pcn()")
	public void around(JoinPoint joinpoint) {

		Signature signature = joinpoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		Person person = method.getAnnotation(Person.class);
		System.out.println(person);

		ExpressionParser parser = new SpelExpressionParser();
		LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

		String[] params = discoverer.getParameterNames(method);

		EvaluationContext context = new StandardEvaluationContext();
		for (int len = 0; len < params.length; len++) {
			context.setVariable(params[len], joinpoint.getArgs()[len]);
		}
		System.out.println(parser.parseExpression(person.name()).getValue(context, String.class));
	}

	@After(value = "pcn()")
	public void after() {
		System.out.println("after。。。。。");
	}
}
