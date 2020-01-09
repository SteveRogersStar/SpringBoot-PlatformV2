package com.medical.platform.controller;

//import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: SpringBoot-Druid-Mybatis
 * @description:  JDBC测试

 * @author: heyu
 * @create: 2020-01-07 11:50
 **/

@Api(value = "Jdbc测试接口", tags = "用户接口模块")
@RestController
@RequestMapping(value = "jdbc")
public class JdbcTestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询student表中所有数据
    //List 中的1个 Map 对应数据库的 1行数据
    //Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
    @ApiOperation(value = "获取所有用户列表",notes = "这是一个Jdbc 的Query测试")
    //@ApiImplicitParam(name = "List<Map<String, Object>>", value = "用户对象列表", dataType = "Map<string, object>>")
    //@RequestMapping(value = "userlist",method = RequestMethod.GET)
    @GetMapping("/list")
    public List<Map<String, Object>> list(){
        String sql = "select * from user_info";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //新增一个用户
    @ApiOperation(value = "添加用户信息",notes = "这是一个Jdbc 的Add测试")
    @GetMapping("/addUser")
    public String addUser(){
        //插入语句
        String sql = "insert into user_info(id, username, password) values (4,'小明','123456')";
        jdbcTemplate.update(sql);
        //查询
        return "addUser-ok";
    }

    //修改用户信息
    @ApiOperation(value = "修改用户信息",notes = "这是一个Jdbc 的modify测试")
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id")@ApiParam(name="id",value="用户id",required=true)int id){
        //插入语句
        String sql = "update user_info set username=?,password=? where id="+id;
        //数据
        Object[] objects = new Object[2];
        objects[0] = "小明2";
        objects[1] = "zxcvbn";
        jdbcTemplate.update(sql,objects);
        //查询
        return "updateUser-ok";
    }

    //删除用户
    @ApiOperation(value = "删除用户信息",notes = "这是一个Jdbc 的del测试")
    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") int id){
        //插入语句
        String sql = "delete from user_info where id=?";
        jdbcTemplate.update(sql,id);
        //查询
        return "delUser-ok";
    }
}
