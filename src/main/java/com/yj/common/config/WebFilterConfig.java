package com.yj.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * 通过此类实现过滤器的一些配置
 * @author UID
 *
 */
@Configuration
public class WebFilterConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean("filterRegistrationBean")
	public FilterRegistrationBean newFilterRegistrationBean() {
		//1.构建过滤器的注册器对象
		FilterRegistrationBean fBean = new FilterRegistrationBean<>();
		//2.注册
		DelegatingFilterProxy filter = new DelegatingFilterProxy("shiroFilterFactoryBean");
		fBean.setFilter(filter);
		//3.进行过滤器配置
		//3.1配置过滤器的声明周期管理,交给servletContext负责
		fBean.setEnabled(true);
		fBean.addUrlPatterns("/*");
		return fBean;
	}
	
}
