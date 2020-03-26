package com.vivachek.cloud.profiledemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author CJB
 * @Date 2020/3/25 11:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestHeader {
    private String token;
    private String version;
    private String platform;
}