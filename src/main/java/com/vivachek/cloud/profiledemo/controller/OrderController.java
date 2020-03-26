package com.vivachek.cloud.profiledemo.controller;

import com.vivachek.cloud.profiledemo.annotation.RepeatLimiter;
import com.vivachek.cloud.profiledemo.domain.CommenResult;
import com.vivachek.cloud.profiledemo.domain.Order;
import com.vivachek.cloud.profiledemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 9:57
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 下单
     * @param order
     * @return
     */
    @PostMapping
    @RepeatLimiter  //幂等性保证
    public CommenResult add(@RequestBody Order order){
        orderService.save(order);
        return new CommenResult("200","下单成功");
    }
}