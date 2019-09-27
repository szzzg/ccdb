package com.movitech.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: restful-api-spring
 * @version create time：2019年9月27日上午9:53:04
 * @author: 周志刚
 * @ClassName: Person
 * @Description: TODO
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Person {

	String value() default "";

	String name();

	PersonSex sex();
}
