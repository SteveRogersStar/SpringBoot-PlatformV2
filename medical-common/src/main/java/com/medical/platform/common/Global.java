package com.medical.platform.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-druid-mybatis
 * @description: 全局配置信息类
 * @author: heyu
 * @create: 2020-01-07 21:34
 **/
@Data
@Component
@ConfigurationProperties("project")
public class Global {
    /** 项目名称 */
    private  String name;

    /** 版本 */
    private  String version;

    /**工程描述(项目说明)*/
    private  String description;

    /** 版权年份 */
    private  String copyrightYear;

    /**作者信息*/
    private AuthorInfo author;
    
    /** 上传路径 */
    private  String profile;

    /**
     * 获取下载路径
     */
    public  String getDownloadPath()
    {
        return profile + "/download/";
    }

    /**
     * 获取上传路径
     */
    public  String getUploadPath()
    {
        return profile + "/upload";
    }
}
