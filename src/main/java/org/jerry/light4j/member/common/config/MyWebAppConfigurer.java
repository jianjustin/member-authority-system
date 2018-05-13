package org.jerry.light4j.member.common.config;

import org.jerry.light4j.member.common.interceptor.URLInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 收集配置信息
 * @author admin
 *
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer{

	/**
	 * 组装拦截器链
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new URLInterceptor()).addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	/**
	 * 静态资源加载
	 */
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
