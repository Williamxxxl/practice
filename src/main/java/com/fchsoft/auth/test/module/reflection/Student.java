package com.fchsoft.auth.test.module.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName student.java
 * @Description
 * @createTime 2022-01-12 14:05
 */
@MyAnn(name = "张三", isOk = false)
@Data
@AllArgsConstructor
public class Student {

    @MyAnn
    private boolean isInClass;
    private Integer age;
    private String name;

    public Student() {
    }

    public String sayHello(String name, Integer age){
        return "hello world! 我叫"+name+",今年" + age + "岁了";
    }

}
