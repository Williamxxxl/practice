package com.fchsoft.auth.test.module.ticket.service.impl;

import com.fchsoft.auth.test.module.redis.service.RedisService;
import com.fchsoft.auth.test.module.ticket.entity.DictMovieTicket;
import com.fchsoft.auth.test.module.ticket.mapper.DictMovieTicketMapper;
import com.fchsoft.auth.test.module.ticket.service.IDictMovieTicketService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qw
 * @since 2022-01-20
 */
@Service
public class DictMovieTicketServiceImpl extends ServiceImpl<DictMovieTicketMapper, DictMovieTicket> implements IDictMovieTicketService {

    Object flag = new Object();

    public static final String MN = "夏洛特烦恼";

    public Integer total;

    public Integer getTotal() {
        return (Integer) redisService.hget("ticket_num", MN);
    }

    @Autowired
    private RedisService redisService;

    public boolean sellTicket() {
        Integer ticketNum = (Integer) redisService.hget("ticket_num", MN);
        redisService.hset("ticket_num", MN, ticketNum - 1);
        System.out.println("电影票还剩" + redisService.hget("ticket_num", MN) + "张");
        return true;
    }

    @Cacheable(cacheNames = "movieData", key = "#root.methodName")
    public List<DictMovieTicket> getMovieList(){
        return lambdaQuery()
                .list();
    }

    public void sell() {
        ExecutorService es = Executors.newFixedThreadPool(5);
//        while (true) {
//            es.submit(() -> {
//
//                synchronized (this.flag) {
//                    if (this.getTotal() > 0) {
//                        try {
//                            Thread.sleep(500);
//                            sellTicket();
//                            String msg = Thread.currentThread().getName() + " 售票";
//                            System.out.println(msg);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    } else {
//                        System.out.println("票已售完，请下次再来！");
//                        System.exit(0);
//                    }
//                }
//
//            });z
//
//        }
    }

}
