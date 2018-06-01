/*package org.jerry.light4j.member.common.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.jerry.light4j.member.business.member.role.domain.MemberRole;
import org.jerry.light4j.member.business.member.role.repository.MemberRoleRepository;
import org.jerry.light4j.member.business.member.user.domain.MemberUser;
import org.jerry.light4j.member.business.member.user.repository.MemberUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private MemberUserRepository memberUserRepository;
	@Autowired
	private MemberRoleRepository memberRoleRepository;
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//从凭证中获得用户名
		String memberUserCode = (String) SecurityUtils.getSubject().getPrincipal();
		//根据用户名查询用户对象
		MemberUser memberUser = memberUserRepository.findByMemberUserCode(memberUserCode);
		//查询用户拥有的角色
		MemberRole memberRole = memberRoleRepository.findByMemberRoleCode(memberUser.getMemberUserRoleCode());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole(memberRole.getmemberRoleCode());
		return info;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		//从凭证中获得用户名
		String memberUserCode = (String) SecurityUtils.getSubject().getPrincipal();
		//根据用户名查询用户对象
		MemberUser memberUser = memberUserRepository.findByMemberUserCode(memberUserCode);
		if (memberUser == null) {
			throw new UnknownAccountException(
					"没有在本系统中找到对应的用户信息。");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(memberUser.getMemberUserLoginAccount(), memberUser.getMemberUserLoginPassword(),memberUser.getMemberUserCode());
		return info;
	}

	public MemberUserRepository getMemberUserRepository() {
		return memberUserRepository;
	}
	public void setMemberUserRepository(MemberUserRepository memberUserRepository) {
		this.memberUserRepository = memberUserRepository;
	}
	public MemberRoleRepository getMemberRoleRepository() {
		return memberRoleRepository;
	}
	public void setMemberRoleRepository(MemberRoleRepository memberRoleRepository) {
		this.memberRoleRepository = memberRoleRepository;
	}
}
*/