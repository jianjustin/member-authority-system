package org.jerry.light4j.member.common.security;

import java.util.Collection;

import org.jerry.light4j.member.business.member.user.domain.MemberUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MyUserPrincipal implements UserDetails{

	private static final long serialVersionUID = -7580815771176742602L;
	@Autowired
	private MemberUser memberUser;
	
	public MyUserPrincipal(MemberUser memberUser) {
		this.memberUser = memberUser;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return memberUser.getMemberUserLoginPassword();
	}

	@Override
	public String getUsername() {
		return memberUser.getMemberUserLoginAccount();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public MemberUser getMemberUser() {
		return memberUser;
	}

	public void setMemberUser(MemberUser memberUser) {
		this.memberUser = memberUser;
	}
	
	

}
