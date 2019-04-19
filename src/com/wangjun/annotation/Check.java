package com.wangjun.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author wangjun
 * @date 2019-03-22
 * @version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
	String value();
}
