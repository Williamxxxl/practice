package com.fchsoft.auth.test.module.ticket.controller;


import com.fchsoft.auth.test.common.entity.CommonResult;
import com.fchsoft.auth.test.module.ticket.entity.DictMovieTicket;
import com.fchsoft.auth.test.module.ticket.service.impl.DictMovieTicketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qw
 * @since 2022-01-20
 */
@Slf4j
@RestController
@RequestMapping("/ticket")
public class DictMovieTicketController {

    @Autowired
    private DictMovieTicketServiceImpl service;

    @GetMapping("/sell")
    public CommonResult sell() {
        CommonResult r;
        try {
            service.sell();
            r = CommonResult.ok();
        }catch (Exception e){
            log.error("[{}]:  error, errMsg: 111[{}] ", e.getMessage(), e);
            r = CommonResult.error().data(e.getMessage()).exception(e);
        }
        return r;
    }

    @GetMapping("/getMovieList")
    public CommonResult getMovieList(){
        return CommonResult.ok().data(service.getMovieList());
    }

}
