package com.vivachek.cloud.profiledemo.exception;

import com.vivachek.cloud.profiledemo.domain.CommenResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 10:39
 */
@RestControllerAdvice
@Slf4j
public class ServiceExceptionHandler {

    @ExceptionHandler(value = {TokenInvalidException.class})
    public CommenResult onException(TokenInvalidException ex){
        log.error(ex.getMessage());
        return new CommenResult("10001", ex.getMessage());
    }


    @ExceptionHandler(value = {RepeatException.class})
    public CommenResult onException(RepeatException ex){
        log.error(ex.getMessage());
        return new CommenResult(ex.getCode(), ex.getMessage());
    }

}