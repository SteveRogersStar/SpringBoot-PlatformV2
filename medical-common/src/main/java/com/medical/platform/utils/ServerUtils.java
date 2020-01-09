package com.medical.platform.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springboot-druid-mybatis
 * @description: 获取服务端请求路径, 包括:域名,端口,上下文访问路径
 * @author: heyu
 * @create: 2020-01-07 22:12
 **/
public class ServerUtils {
    /**
     * 获取完整的请求路径，包括：域名，端口，上下文访问路径
     *
     * @return 服务地址
     */
    public String getUrl()
    {
        HttpServletRequest request = ServletUtils.getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request)
    {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}
