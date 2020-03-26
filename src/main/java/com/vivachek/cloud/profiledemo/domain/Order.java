package com.vivachek.cloud.profiledemo.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order implements Serializable {
    private String orderId;
    private Long money;
    private String name;
    private String goodsId;
}