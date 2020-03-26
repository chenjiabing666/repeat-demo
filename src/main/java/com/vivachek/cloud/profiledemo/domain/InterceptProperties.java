package com.vivachek.cloud.profiledemo.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description 拦截器的参数配置
 * @Author CJB
 * @Date 2020/3/25 11:35
 */
@Data
@ConfigurationProperties(prefix = "spring.intercept")
public class InterceptProperties {
    /**
     * 请求头拦截器的排除uri
     */
    private String[] headInterceptExclude=new String[]{};

    /**
     * 重复提交拦截器排除的uri
     */
    private String[] repeatInterceptExclude=new String[]{};
}