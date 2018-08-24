package org.jerry.light4j.member.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket basicImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("basic")
				.select().paths(PathSelectors.ant("/basic/**")).build()
				.apiInfo(apiInfo());
	}
	
	@Bean
	public Docket memberImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("member")
				.select().paths(PathSelectors.ant("/member/**")).build()
				.apiInfo(apiInfo());
	}
	
	@Bean
	public Docket systemImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("system")
				.select().paths(PathSelectors.ant("/system/**")).build()
				.apiInfo(apiInfo());
	}
	
	@Bean
	public Docket oauthImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("oauth")
				.select().paths(PathSelectors.ant("/oauth/**")).build()
				.apiInfo(apiInfo());
	}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基于Spring Boot的用户权限系统")
                .license("获取授权码")
				.licenseUrl("oauth/authorize?client_id=client_1&response_type=code&redirect_uri=http://127.0.0.1:18125")
                .build();
    }
    
    
}
