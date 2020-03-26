package com.vivachek.cloud.profiledemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 9:59
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommenResult<T> {
    private String code;
    private String message;
    private T body;

    public CommenResult(String code,String message){
        this(code,message,null);
    }
}