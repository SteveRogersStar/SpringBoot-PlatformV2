package com.medical.platform.services;

import com.medical.platform.model.UserInfo;

import java.util.List;

/**
 * @program: springboot-druid-mybatis
 * @description:
 * @author: heyu
 * @create: 2020-01-08 12:30
 **/

public interface UserInfoService {

    public List<UserInfo> selectAll();
}
