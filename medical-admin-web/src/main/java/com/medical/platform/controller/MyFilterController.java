package com.medical.platform.controller;

import com.medical.platform.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/api")
public class MyFilterController {

    @GetMapping("/user/filter")
    public String hello()
    {
        return  "我被myFilter过滤器监控了";
    }

    @GetMapping("/user/list")
    public List<UserInfo> list()
    {
        List<UserInfo> userInfoList = new ArrayList<>();
        UserInfo userInfo =new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("123456");
        userInfoList.add(userInfo);
        return  userInfoList;
    }

    @GetMapping("/home/open/info")
    public String getHome()
    {
        return "欢迎访问首页";
    }

    @GetMapping("/open/unLogin")
    public String getUnLogin()
    {
        return "登录失效,请重新登录";
    }

}
