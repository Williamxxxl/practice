package com.fchsoft.auth.test.module.reflection;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName TestImpl.java
 * @Description
 * @createTime 2022-01-12 15:11
 */
public class TestImpl implements Test{
    @Override
    public String getName(Integer num) {
        return num.toString();
    }
}
