package com.fchsoft.auth.test.module.introspector;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName employee.java
 * @Description javabean内省机制
 * @createTime 2022-01-14 16:53
 */
public class Employee {

    private String name;
    private Integer age;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
