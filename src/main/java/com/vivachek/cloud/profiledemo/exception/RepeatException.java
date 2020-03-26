package com.vivachek.cloud.profiledemo.exception;

import lombok.Data;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 11:31
 */
@Data
public class RepeatException extends RuntimeException {
    private String code;
    public RepeatException(){
        super("请勿重复请求！！！");
        this.code="10002";
    }
}