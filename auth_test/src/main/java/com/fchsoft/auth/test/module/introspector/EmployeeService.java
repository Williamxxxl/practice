package com.fchsoft.auth.test.module.introspector;

import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName EmployeeService.java
 * @Description javabean内省机制
 * @createTime 2022-01-14 16:55
 */
@Service
public class EmployeeService {

    public Map<String, List<String>> getProps(){
        Map<String, List<String>> map = new HashMap();
        List<String> props = new ArrayList<>();
        List<String> readMethods = new ArrayList<>();
        List<String> writeMethods = new ArrayList<>();
        try {
            //获取javabean的baseinfo对象
            BeanInfo beanInfo = Introspector.getBeanInfo(Employee.class);
            //获取javabean的属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor prop : propertyDescriptors) {
                props.add(prop.getName()); //获取属性名
                if (!prop.getName().equals("class")){
                    readMethods.add(prop.getReadMethod().getName());  //获取属性的get方法
                    writeMethods.add(prop.getWriteMethod().getName());  //获取属性的set方法
                }
                map.put("props", props);
                map.put("readMethods", readMethods);
                map.put("writeMethods", writeMethods);
            }
        } catch (IntrospectionException e) {
            map = null;
            e.printStackTrace();
        }
        return map;
    }

}
