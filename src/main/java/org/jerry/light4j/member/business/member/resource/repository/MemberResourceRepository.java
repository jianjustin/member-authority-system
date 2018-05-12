package org.jerry.light4j.member.business.member.resource.repository;

import java.io.Serializable;

import org.jerry.light4j.member.common.base.repository.BaseMotifyRepository;
import org.jerry.light4j.member.business.member.resource.domain.MemberResource;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author janine
 * @since 2017-12-12
 *********************************************/
@Repository
public interface MemberResourceRepository extends BaseMotifyRepository<MemberResource, Serializable>{

	public MemberResource findByMemberResourceCode(String memberResourceCode);

	
}
