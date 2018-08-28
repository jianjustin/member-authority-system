package org.jerry.light4j.member.common.security;

import org.jerry.light4j.member.business.member.user.domain.MemberUser;
import org.jerry.light4j.member.business.member.user.repository.MemberUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 自定义用户组件
 * @author chenjianrui
 *
 */
@Component("userDetailsService")
public class CustomizeUserDetailsService implements UserDetailsService{

	@Autowired
	private MemberUserRepository memberUserRepository;
	
	/**
	 * 根据用户账号获取用户实体数据
	 * @author chenjianrui
	 */
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		MemberUser memberUser = memberUserRepository.findByMemberUserLoginAccount(arg0);
		if (memberUser == null) {
            throw new UsernameNotFoundException(memberUser.getMemberUserLoginAccount());
        }
        return new User(memberUser.getMemberUserLoginAccount(),memberUser.getMemberUserLoginPassword(),null);
	}

}
