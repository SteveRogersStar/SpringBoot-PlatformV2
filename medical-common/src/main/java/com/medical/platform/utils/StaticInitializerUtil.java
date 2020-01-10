package com.medical.platform.utils;

import com.medical.platform.entity.TokenSettings;
import org.springframework.stereotype.Component;


@Component
public class StaticInitializerUtil {

    private TokenSettings tokenSettings;

    public StaticInitializerUtil(TokenSettings tokenSettings) {

        JwtTokenUtil.setTokenSettings(tokenSettings);
    }
}

