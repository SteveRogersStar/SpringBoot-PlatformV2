package com.medical.platform.controller;

import com.medical.platform.model.UserInfo;
import com.medical.platform.services.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: springboot-druid-mybatis
 * @description: 用户信息控制器
 * @author: heyu
 * @create: 2020-01-08 12:29
 **/

@Api(value = "user", tags = "用户接口模块")
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "所有用户", notes = "获取所有用户信息")
    @GetMapping(value = "list")
    public List<UserInfo> list()
    {
        return  userInfoService.selectAll();
    }
}
