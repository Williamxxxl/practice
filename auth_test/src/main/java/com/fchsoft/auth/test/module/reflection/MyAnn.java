package com.fchsoft.auth.test.module.reflection;

import java.lang.annotation.*;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName MyAnn.java
 * @Description
 * @createTime 2022-01-12 15:21
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface MyAnn {
    boolean isOk() default true;
    String name() default "tttt";
}
