package org.jerry.light4j.member.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 浏览器基础安全认证
 * @author jian
 *
 */
@Configuration
@EnableWebSecurity
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
	    auth
	        .userDetailsService(new CustomUserDetailsService())
	        .and()
	        .authenticationProvider(authenticationProvider());
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
        auth.userDetailsService(new CustomUserDetailsService());
    }


	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(new CustomUserDetailsService());
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder(11);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated();

	}

	
}
