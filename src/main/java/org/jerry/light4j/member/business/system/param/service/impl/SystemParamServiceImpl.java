package org.jerry.light4j.member.business.system.param.service.impl;

import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.business.system.param.domain.SystemParam;
import org.jerry.light4j.member.business.system.param.repository.SystemParamRepository;
import org.jerry.light4j.member.business.system.param.service.SystemParamService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemParamServiceImpl implements SystemParamService{
	@Autowired
	private SystemParamRepository systemParamRepository;
	@Autowired
	private BaseQueryRepositoryImpl<SystemParam, Serializable> baseQueryRepositoryImpl;
	
	public SystemParam save(SystemParam systemParam) {
		return systemParamRepository.save(systemParam);
	}
	
	public SystemParam update(SystemParam systemParam) {
		return systemParamRepository.save(systemParam);
	}

	public SystemParam delete(SystemParam systemParam) {
		systemParamRepository.delete(systemParam);
	    return systemParam;
	}
	
	public  List<SystemParam> queryAllByJPQL(String jpql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllByJPQL(jpql, paramValueList, SystemParam.class);
	}

	public List<Map<String, Object>> queryAllColumnByJPQL(String jpql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnByJPQL(jpql, paramValueList, SystemParam.class);
	}

	public  List<SystemParam> queryAllBySQL(String sql, List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllBySQL(sql, paramValueList, SystemParam.class);
	}

	public List<Map<String, Object>> queryAllColumnBySQL(String sql,List<Object> paramValueList) {
		return baseQueryRepositoryImpl.queryAllColumnBySQL(sql, paramValueList, SystemParam.class);
	}
	

	public SystemParamRepository getSystemParamRepository() {
		return systemParamRepository;
	}
	public void setSystemParamRepository(SystemParamRepository systemParamRepository) {
		this.systemParamRepository = systemParamRepository;
	}
	public BaseQueryRepositoryImpl<SystemParam, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(BaseQueryRepositoryImpl<SystemParam, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
}
