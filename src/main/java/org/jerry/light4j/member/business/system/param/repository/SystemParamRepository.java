package org.jerry.light4j.member.business.system.param.repository;

import java.io.Serializable;

import org.jerry.light4j.member.common.base.repository.BaseMotifyRepository;
import org.jerry.light4j.member.business.system.param.domain.SystemParam;
import org.springframework.stereotype.Repository;

/********************************************
 * 实体操作接口
 * @author janine
 * @since 2017-12-12
 *********************************************/
@Repository
public interface SystemParamRepository extends BaseMotifyRepository<SystemParam, Serializable>{

	public SystemParam findBySystemParamCode(String systemParamCode);

	
}
