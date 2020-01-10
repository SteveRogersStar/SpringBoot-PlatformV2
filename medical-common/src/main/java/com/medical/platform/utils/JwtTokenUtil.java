package com.medical.platform.utils;

import com.medical.platform.entity.TokenSettings;

/*
* 通过静态工具类读取yml 配置文件
* */
public class JwtTokenUtil {

    private  static String secretKey;

    private  static String issuer;

    public static void  setTokenSettings(TokenSettings tokenSettings)
    {
        secretKey = tokenSettings.getSecretKey();
        issuer = tokenSettings.getIssuer();
    }

    public  static  String getToken()
    {
        return secretKey + issuer;
    }
}
