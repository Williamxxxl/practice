package com.fchsoft.auth.test.module.ioStream;

import com.fchsoft.auth.test.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * @author qw
 * @version 1.0.0
 * @ClassName IoStreamController.java
 * @Description
 * @createTime 2022-01-16 21:47
 */
@Slf4j
@RestController
public class IoStreamController {

    @Autowired
    private IoStreamService service;

    @GetMapping("/fileTest")
    public CommonResult fileTest() {
        CommonResult r;
        try {
            r = CommonResult.ok().data(service.test());
        } catch (Exception e) {
            log.error("{} file test error {}", e.getMessage(), e);
            r = CommonResult.error().data(e.getMessage());
        }
        return r;
    }

    @GetMapping("/outTest")
    public CommonResult outTest() {
        service.outTest();
        return CommonResult.ok();
    }

    @GetMapping("/inTest")
    public CommonResult inTest() {
        service.inTest();
        return CommonResult.ok();
    }

    @GetMapping("/writerTest")
    public CommonResult writeTest(String fileName, String content) throws IOException {
        service.writerTest(fileName, content);
        return CommonResult.ok();
    }

    @GetMapping("/readerTest")
    public CommonResult readerTest(String filename) throws IOException {
        return CommonResult.ok().data(service.readerTest(filename));
    }

    @GetMapping("/nioTest")
    public CommonResult nioTest(String source, String target) throws IOException {
        service.nioTest(new File(source), new File(target));
        return CommonResult.ok();
    }

}
