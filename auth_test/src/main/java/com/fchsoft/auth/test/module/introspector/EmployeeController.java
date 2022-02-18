package com.fchsoft.auth.test.module.introspector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName Introspector.java
 * @Description
 * @createTime 2022-01-14 17:02
 */
@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/getProps")
    public Map<String, List<String>> getProps(){
        return service.getProps();
    }
}
