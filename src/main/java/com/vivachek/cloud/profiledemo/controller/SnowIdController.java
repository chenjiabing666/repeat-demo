package com.vivachek.cloud.profiledemo.controller;

import com.vivachek.cloud.profiledemo.domain.CommenResult;
import com.vivachek.cloud.profiledemo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 14:54
 */
@RestController
@RequestMapping("/id")
public class SnowIdController {

    @Autowired
    private TokenService tokenService;

    /**
     * 获取全局唯一id
     * @return
     */
    @GetMapping
    public CommenResult getId(){
        return new CommenResult("200", "请求成功",tokenService.getToken() );
    }
}