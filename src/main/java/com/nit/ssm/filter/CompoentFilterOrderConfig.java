package com.nit.ssm.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class CompoentFilterOrderConfig {
    @Bean
    public Filter LoginFilter(){
        return new LoginFilter();//自定义的过滤器
    }
    @Bean
    public Filter ManagerFilter(){
        return new ManagerFilter();//自定义的过滤器
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean1(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(LoginFilter());
        filterRegistrationBean.addUrlPatterns("/pages/*");
        filterRegistrationBean.setOrder(1);//order的数值越小 则优先级越高
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(ManagerFilter());
        filterRegistrationBean.addUrlPatterns("/pages/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }


}
