package com.vivachek.cloud.profiledemo.intercept;

import com.vivachek.cloud.profiledemo.domain.RequestHeader;
import com.vivachek.cloud.profiledemo.domain.constants.HeaderConstant;
import com.vivachek.cloud.profiledemo.exception.TokenInvalidException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 获取请求头的信息，具体校验逻辑读者自己实现
 * @Author CJB
 * @Date 2020/3/25 11:09
 */
@Component
public class HeaderIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取token
        String token = request.getHeader(HeaderConstant.TOKEN);
        //校验逻辑
        if (!validToken(token))
            throw new TokenInvalidException("TOKEN失效");
        //获取其他的参数.....
        RequestHeader header = RequestHeader.builder()
                .token(token)
                .build();
        //放入request中
        request.setAttribute(HeaderConstant.HEADER_INFO,header);
        return true;
    }

    /**
     * 校验token，逻辑自己实现
     * @param token
     * @return
     */
    private boolean validToken(String token){
        return Boolean.TRUE;
    }

}