package com.medical.platform.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 通过 @Value读取配置参数值
 * */
@RestController
@RequestMapping("/jwt")
public class JwtReadController {

    @Value("${jwt.secretKey}")
    private  String secretKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @GetMapping(value = "token")
    public  String getJwtToken()
    {
        return  "secretKey:"+secretKey+" "+"issuer:"+issuer;
    }
}
