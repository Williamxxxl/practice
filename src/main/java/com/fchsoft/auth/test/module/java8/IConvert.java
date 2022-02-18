package com.fchsoft.auth.test.module.java8;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName IConvert.java
 * @Description
 * @createTime 2022-02-18 16:48
 */
@FunctionalInterface
public interface IConvert<F,T> {
    T convert(F f);
}
