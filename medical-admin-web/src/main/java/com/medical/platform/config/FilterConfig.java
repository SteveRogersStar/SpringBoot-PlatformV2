package com.medical.platform.config;

import com.medical.platform.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public MyFilter myFilter()
    {
        return new MyFilter();
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(MyFilter myFilter)
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/api/*");
        filterRegistrationBean.setName("myFilter");
        return filterRegistrationBean;
    }
}
