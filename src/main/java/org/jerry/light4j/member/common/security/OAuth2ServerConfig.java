package org.jerry.light4j.member.common.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

public class OAuth2ServerConfig {
	
	private static final String DEMO_RESOURCE_ID = "member";

	/**
	 * 资源服务器配置
	 * @author jian
	 *
	 */
    @Configuration
    @EnableResourceServer
    @Order(2)
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
           
            
    		http
	        .anonymous()
	        	.and()
			.authorizeRequests()
				.antMatchers("/order/**").authenticated()
				.and()
			.exceptionHandling()
				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
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
        
        private static String REALM="MY_OAUTH_REALM";

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        private TokenStore tokenStore;

        @Autowired
        AuthorizationEndpoint authorizationEndpoint;

        @Autowired
        CustomizeUserDetailsService customizeUserDetailsService;

        @Autowired
        private UserApprovalHandler userApprovalHandler;

        @Autowired
        private ClientDetailsService clientDetailsService;

        @Bean
        @Autowired
        public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
            TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
            handler.setTokenStore(tokenStore);
            handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
            handler.setClientDetailsService(clientDetailsService);
            return handler;
        }

        @Bean
        @Autowired
        public ApprovalStore approvalStore(TokenStore tokenStore) {
            TokenApprovalStore store = new TokenApprovalStore();
            store.setTokenStore(tokenStore());
            return store;
        }

        @PostConstruct
        public void init() {
            authorizationEndpoint.setUserApprovalPage("forward:/oauth/my_approval");
            authorizationEndpoint.setErrorPage("forward:/oauth/my_error");
        }



        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

            clients.inMemory()
                    .withClient("fbed1d1b4b1449daa4bc49397cbe2350")
                    .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                    .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                    .scopes("read","write")
                    .secret("fbed1d1b4b1449daa4bc49397cbe2350")
                    .accessTokenValiditySeconds(120)//Access token is only valid for 2 minutes.
                    .refreshTokenValiditySeconds(600)//Refresh token is only valid for 10 minutes.
                    .redirectUris("http://localhost:8080/session");

        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .authenticationManager(authenticationManager)
                    .userDetailsService(customizeUserDetailsService)
                    .userApprovalHandler(userApprovalHandler)
                    .tokenEnhancer(new CustomTokenEnhancer())
                    .tokenStore(tokenStore);
            //endpoints.pathMapping(String "/oauth/confirm_access","/oauth/my_approval");
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) {
            security
                    .allowFormAuthenticationForClients()
                    .tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()")
                    .realm(REALM+"/client");
        }
        
        @Bean
        public TokenStore tokenStore() {
          return new InMemoryTokenStore();
        }
        
        

    }

}
