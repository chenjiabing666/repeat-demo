package com.vivachek.cloud.profiledemo.service;

import com.vivachek.cloud.profiledemo.domain.Order;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 10:07
 */
public interface OrderService {
    /**
     * 模拟下单
     * @param order
     */
    void save(Order order);
}