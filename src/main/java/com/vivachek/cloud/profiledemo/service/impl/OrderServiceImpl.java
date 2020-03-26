package com.vivachek.cloud.profiledemo.service.impl;

import com.vivachek.cloud.profiledemo.domain.Order;
import com.vivachek.cloud.profiledemo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 10:08
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Override
    public void save(Order order) {
        log.debug(order.toString());
        log.debug("下单成功.........");
    }
}