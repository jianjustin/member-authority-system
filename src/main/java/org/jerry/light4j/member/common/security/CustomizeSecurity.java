package org.jerry.light4j.member.common.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 自定义安全认证
 * @author jian
 *
 */
@Component("customizeSecurity")
public class CustomizeSecurity {
	
	public boolean check(Authentication authentication, HttpServletRequest request) {
		Object principal = authentication.getPrincipal();
		System.out.println(ReflectionToStringBuilder.toString(authentication.getAuthorities(),ToStringStyle.MULTI_LINE_STYLE));
		authentication.getName();
		return true;
	}

}
