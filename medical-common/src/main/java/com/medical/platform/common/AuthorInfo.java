package com.medical.platform.common;

import lombok.Data;

/**
 * @program: springboot-druid-mybatis
 * @description: 作者联系方式
 * @author: heyu
 * @create: 2020-01-07 23:26
 **/
@Data
public class AuthorInfo {

    private String name;

    private String url;

    private String email;
}
