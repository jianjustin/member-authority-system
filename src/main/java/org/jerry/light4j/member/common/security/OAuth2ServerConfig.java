package org.jerry.light4j.member.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * oauth2服务器配置
 * @author jian
 *
 */
public class OAuth2ServerConfig {
	
	private static final String DEMO_RESOURCE_ID = "member";

	/**
	 * 资源服务器配置
	 * @author jian
	 *
	 */
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/oauth/**").authenticated()
                    .antMatchers("/member/**").authenticated();
        }
    }


    /**
     * 认证服务器配置
     * @author jian
     *
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        AuthenticationManager authenticationManager;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            //配置两个客户端,一个用于password认证一个用于client认证
        	clients.inMemory()
		            .withClient("demoApp")
		            .secret("demoAppSecret")
		            .redirectUris("http://baidu.com")
		            .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token",
		                    "password", "implicit")
		            .scopes("all")
		            .resourceIds("oauth2-resource")
		            .accessTokenValiditySeconds(1200)
		            .refreshTokenValiditySeconds(50000);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(tokenStore())
                    .userDetailsService(new CustomizeUserDetailsService())
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer
                    .realm("oauth2-resources")
                    .tokenKeyAccess("permitAll()") //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
                    .checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
                    .allowFormAuthenticationForClients()
                    .passwordEncoder(passwordEncoder());
        }

        @Bean
        public TokenStore tokenStore() {
            return new InMemoryTokenStore();
        }
        
        @Bean
        public static NoOpPasswordEncoder passwordEncoder() {
          return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }
        
        

    }

}
