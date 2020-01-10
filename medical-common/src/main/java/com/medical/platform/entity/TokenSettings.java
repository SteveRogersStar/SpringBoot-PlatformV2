package com.medical.platform.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class TokenSettings {
    private  String secretKey;
    private  String issuer;
}
