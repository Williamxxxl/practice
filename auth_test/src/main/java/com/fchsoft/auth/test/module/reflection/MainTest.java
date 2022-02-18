package com.fchsoft.auth.test.module.reflection;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName main.java
 * @Description 反射练习
 * @createTime 2022-01-12 14:06
 */
@Slf4j
public class MainTest {
    public static void main(String[] args) {
        try {
            boolean cflag = Student.class.isAnnotationPresent(MyAnn.class);
            //反射获取类的注解
            MyAnn annotation = Student.class.getAnnotation(MyAnn.class);
            Field isInClass = Student.class.getDeclaredField("isInClass");
            boolean fflag = isInClass.isAnnotationPresent(MyAnn.class);
            if (cflag && fflag) {
                //反射获取属性的注解
                MyAnn annotation1 = isInClass.getAnnotation(MyAnn.class);
                Student student = new Student(annotation1.isOk(), 18, annotation.name());
                System.out.println(student.toString());
                //反射获取无参数构造方法
                Student student1 = Student.class.newInstance();
                //反射获取全参数构造方法
                Constructor<Student> constructor = Student.class.getConstructor(boolean.class, Integer.class, String.class);
                Student student2 = constructor.newInstance(annotation1.isOk(), 18, annotation.name());
                Method sayHello = Student.class.getMethod("sayHello", new Class[]{String.class, Integer.class});
                Object invoke = sayHello.invoke(Student.class.newInstance() ,student2.getName(), student2.getAge());
                System.out.println(invoke.toString());
                System.out.println();
                //反射查询所有属性,并输出属性名称
                Field[] declaredFields = Student.class.getDeclaredFields();
                for (int i = 0; i < declaredFields.length; i++) {
                    System.out.println(declaredFields[i].getName());
                }
                System.out.println();
                //反射查询所有方法并调用指定方法
                Method[] methods = Student.class.getMethods();
                for (int i = 0; i < methods.length; i++) {
                    System.out.println(methods[i].getName());
                    if (methods[i].getName().equals("sayHello")){
                        Object hha = methods[i].invoke(Student.class.newInstance(), "hha", 88);
                        Class<?> returnType = methods[i].getReturnType();
                        System.out.println(hha.toString());
                        System.out.println(returnType.getName());
                    }
                }
                System.out.println();
                //反射查询注解
                Annotation[] annotations = Student.class.getAnnotations();
                for (int i = 0; i < annotations.length; i++) {
                    System.out.println(annotations[i].annotationType());
                }
                System.out.println();
            }

        } catch (Exception e) {
            log.error("{} error {}", e.getMessage(), e);
        }
    }
}
