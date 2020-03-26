package com.vivachek.cloud.profiledemo.exception;

/**
 * @Description 令牌认证失效
 * @Author CJB
 * @Date 2020/3/25 10:40
 */
public class TokenInvalidException extends RuntimeException {
    public TokenInvalidException(String msg){
        super(msg);
    }
}