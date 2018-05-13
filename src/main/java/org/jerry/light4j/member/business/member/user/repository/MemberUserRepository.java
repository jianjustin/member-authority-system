package org.jerry.light4j.member.business.member.user.repository;

import java.io.Serializable;

import org.jerry.light4j.member.business.member.user.domain.MemberUser;
import org.jerry.light4j.member.common.base.repository.BaseMotifyRepository;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author janine
 * @since 2017-12-12
 *********************************************/
@Repository
public interface MemberUserRepository extends BaseMotifyRepository<MemberUser, Serializable>{
	
	public MemberUser findByMemberUserCode(String memberUserCode);
	
	public MemberUser findByMemberUserLoginAccountAndMemberUserLoginPassword(String memberUserLoginAccount,String memberUserLoginPassword);

	
}
