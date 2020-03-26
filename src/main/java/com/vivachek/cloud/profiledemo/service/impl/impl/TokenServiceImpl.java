package com.vivachek.cloud.profiledemo.service.impl.impl;

import com.vivachek.cloud.profiledemo.service.TokenService;
import com.vivachek.cloud.profiledemo.utils.SnowflakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 15:56
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getToken() {
        //获取全局唯一id
        long nextId = SnowflakeUtil.nextId();
        //存入redis
        stringRedisTemplate.opsForValue().set(String.valueOf(nextId), UUID.randomUUID().toString(),10, TimeUnit.MINUTES);
        return String.valueOf(nextId);
    }

    @Override
    public Boolean checkToken(String token) {
        return stringRedisTemplate.delete(token);
    }
}