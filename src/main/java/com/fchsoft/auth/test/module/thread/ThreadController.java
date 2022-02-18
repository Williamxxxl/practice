package com.fchsoft.auth.test.module.thread;

import com.fchsoft.auth.test.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName ThreadController.java
 * @Description
 * @createTime 2022-01-19 13:44
 */
@Slf4j
@RestController
public class ThreadController {

    @Autowired
    private ThreadService service;

    @GetMapping("/getThread")
    public CommonResult getThread() {
        service.getThread();
        return CommonResult.ok();
    }

}
