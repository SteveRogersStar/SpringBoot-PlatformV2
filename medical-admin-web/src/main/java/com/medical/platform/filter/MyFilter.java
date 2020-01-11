package com.medical.platform.filter;

import com.alibaba.druid.sql.visitor.functions.Isnull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Path;

/**
 * 第一种方式：通过@WebFilter申明过滤器
 *  /api/*  声明拦截的路劲， myFilter 声明过滤器的名称
 * @Order(1)  声明执行的顺序
 * */
//@Order(1)
//@WebFilter(urlPatterns = "/api/*",filterName = "myFilter")
public class MyFilter implements Filter {

    @Value("${open.url}")
    private  String openUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter我被初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String uri = request.getRequestURI();
        String method =request.getMethod();
        System.out.println("请求的接口="+uri+"请求的方式:"+method);
        //这里做业务逻辑判断
        //例如：登录时，判断是否携带凭证，来确认是否允许登录
        PathMatcher pathMatcher = new AntPathMatcher();
        //如果是开放的Url,直接放行
        if(pathMatcher.match(openUrl,uri))
        {
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
        //非开放的，先进行Token 校验
        else
        {
            //开始校验
            String token = request.getHeader("token");
            if(StringUtils.isEmpty(token))
            {
                //用户认证失败,跳转到重新登录
                servletRequest.getRequestDispatcher("/api/open/unLogin").forward(servletRequest,servletResponse);
            }
            else
            {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter我被销毁");
    }
}
