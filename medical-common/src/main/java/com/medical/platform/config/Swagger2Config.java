package com.medical.platform.config;

import com.medical.platform.common.Global;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: medical-platform-solution
 * @description: Swagger2配置
 * @author: heyu
 * @create: 2020-01-07 16:05
 **/
@Configuration
@EnableSwagger2
@ComponentScan({"com.medical.platform.controller"})
public class Swagger2Config {

    @Autowired
    private Global global;
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例，指定扫描的包路径来定义要建立API的controller目录。
     *
     */
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.medical.platform.controller.*"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    private ApiInfo apiInfo()
//    {
//        return new ApiInfoBuilder()
//                .title("标题："+ global.getName()+"("+ global.getDescription()+")")
//                .description("更多请关注:"+ global.getAuthor().getUrl())
//                // 作者信息
//                .contact(new Contact(global.getAuthor().getName(), null, global.getAuthor().getEmail()))
//                // 版本
//                .version("版本号:" + global.getVersion())
//                .build();
//        }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                global.getAuthor().getName(),
                global.getAuthor().getUrl(),
                global.getAuthor().getEmail());
        return new ApiInfoBuilder()
                .title(global.getName())
                .description(global.getDescription())
                .version(global.getVersion())
                .contact(contact)
                .build();
    }
}
