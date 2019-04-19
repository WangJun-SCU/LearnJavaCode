package com.wangjun.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wangjun
 * @date 2019-03-21
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	int id() default 1;
	String name();
}
