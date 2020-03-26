package com.vivachek.cloud.profiledemo.utils;

import com.vivachek.cloud.profiledemo.domain.RequestHeader;
import com.vivachek.cloud.profiledemo.domain.constants.HeaderConstant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import java.util.Objects;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 11:15
 */
public class RequestContextUtils {
    private RequestContextUtils(){}

    public static ServletRequest getRequest(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static RequestHeader getHeaderInfo(){
        return Objects.requireNonNull((RequestHeader) getRequest().getAttribute(HeaderConstant.HEADER_INFO));
    }
}