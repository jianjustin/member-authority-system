package org.jerry.light4j.member.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * security配置
 * @author jian
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers()
            .anyRequest()
            .and()
            .authorizeRequests()
            .antMatchers("/oauth/*").permitAll()
            // swagger start
            .antMatchers("/swagger-ui.html").permitAll()//配置成临时访问者可访问
            .antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/images/**").permitAll()
            .antMatchers("/webjars/**").permitAll()
            .antMatchers("/v2/api-docs").permitAll()
            .antMatchers("/configuration/ui").permitAll()
            .antMatchers("/configuration/security").permitAll()
            // swagger end
            .anyRequest().access("@customizeSecurity.check(authentication,request)")
            ;
    }
    
    @Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(new CustomizeUserDetailsService())
			.passwordEncoder(passwordEncoder())
			.and();
	}
    
    @Override
	public void configure(WebSecurity web) throws Exception{
         super.configure(web);
    }
	
    
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
      return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
