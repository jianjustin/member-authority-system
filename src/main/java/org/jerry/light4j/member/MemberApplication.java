package org.jerry.light4j.member;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
@EnableSwagger2
public class MemberApplication{

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}
	
	
	

}
