package com.vivachek.cloud.profiledemo.config;

import com.vivachek.cloud.profiledemo.domain.InterceptProperties;
import com.vivachek.cloud.profiledemo.exception.RepeatException;
import com.vivachek.cloud.profiledemo.intercept.HeaderIntercept;
import com.vivachek.cloud.profiledemo.intercept.RepeatIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 注册拦截器
 * @Author CJB
 * @Date 2020/3/25 11:34
 */
@Configuration
@EnableConfigurationProperties(value = {InterceptProperties.class})
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private InterceptProperties interceptProperties;

    @Autowired
    private HeaderIntercept headerIntercept;

    @Autowired
    private RepeatIntercept repeatIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerIntercept).excludePathPatterns(interceptProperties.getHeadInterceptExclude());
        registry.addInterceptor(repeatIntercept).excludePathPatterns(interceptProperties.getRepeatInterceptExclude());
    }
}