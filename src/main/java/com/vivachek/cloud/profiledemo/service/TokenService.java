package com.vivachek.cloud.profiledemo.service;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 15:55
 */
public interface TokenService {
    /**
     * 生成Token
     * @return
     */
    String getToken();

    /**
     * 校验token
     * @param token
     * @return
     */
    Boolean checkToken(String token);
}