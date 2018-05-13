/*package org.jerry.light4j.member.common.shiro;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
		System.out.println("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		filterChainDefinitionMap.put("/static/**", "anon");// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/layui/**", "anon");// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/img/**", "anon");// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/swagger/**", "anon");
		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setLoginUrl("/login");// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setSuccessUrl("/index");// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");//未授权界面;
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		return myShiroRealm;
	}


	@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}
}*/