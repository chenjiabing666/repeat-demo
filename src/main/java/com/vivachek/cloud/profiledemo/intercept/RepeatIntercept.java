package com.vivachek.cloud.profiledemo.intercept;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.vivachek.cloud.profiledemo.service.TokenService;
import com.vivachek.cloud.profiledemo.utils.RequestContextUtils;
import com.vivachek.cloud.profiledemo.annotation.RepeatLimiter;
import com.vivachek.cloud.profiledemo.domain.RequestHeader;
import com.vivachek.cloud.profiledemo.exception.RepeatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description 防止重复提交的拦截器
 * @Author CJB
 * @Date 2020/3/25 10:30
 */
@Component
public class RepeatIntercept implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            //获取方法上的参数
            RepeatLimiter repeatLimiter = AnnotationUtils.findAnnotation(((HandlerMethod) handler).getMethod(), RepeatLimiter.class);

            if (Objects.isNull(repeatLimiter)){
                //获取controller类上注解
                repeatLimiter=AnnotationUtils.findAnnotation(((HandlerMethod) handler).getBean().getClass(),RepeatLimiter.class);
            }

            //使用注解，需要拦截验证
            if (Objects.nonNull(repeatLimiter)){
                //获取全局token，表单提交的唯一id
                RequestHeader info = RequestContextUtils.getHeaderInfo();

                //没有携带token，抛异常，这里的异常需要全局捕获
                if (StringUtils.isEmpty(info.getToken()))
                    throw new RepeatException();

                //校验token
                Boolean flag = tokenService.checkToken(info.getToken());

                //删除失败，表示
                if (Boolean.FALSE.equals(flag))
                    //抛出重复提交的异常
                    throw new RepeatException();
            }
        }
        return true;
    }


}