package com.medical.platform.services.impl;

import com.medical.platform.model.UserInfo;
import com.medical.platform.mapper.UserInfoMapper;
import com.medical.platform.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot-druid-mybatis
 * @description: 用户信息业务逻辑
 * @author: heyu
 * @create: 2020-01-08 12:31
 **/

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }
}
