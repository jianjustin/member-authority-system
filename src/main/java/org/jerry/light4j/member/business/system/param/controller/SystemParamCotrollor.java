package org.jerry.light4j.member.business.system.param.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.business.system.param.domain.SystemParam;
import org.jerry.light4j.member.business.system.param.domain.SystemParamView;
import org.jerry.light4j.member.business.system.param.repository.SystemParamRepository;
import org.jerry.light4j.member.business.system.param.service.SystemParamService;
import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.common.page.PageQueryBean;
import org.jerry.light4j.member.common.page.PageTools;
import org.jerry.light4j.member.common.page.PageUtils;
import org.jerry.light4j.member.common.response.ResponseDomain;
import org.jerry.light4j.member.common.response.ResponseManager;
import org.jerry.light4j.member.common.sql.SqlUtils;
import org.jerry.light4j.member.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/system/param")
public class SystemParamCotrollor{
    @Autowired
	private SystemParamService systemParamService;
    @Autowired
    private BaseQueryRepositoryImpl<SystemParam, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private SystemParamRepository systemParamRepository;
	
	private ResponseEntity<Map<String,Object>> responseEntity;
    
    @ApiOperation(value="数据插入", notes="创建system_param数据",response = SystemParam.class, tags = { "system.param",})
    @RequestMapping(value="/save", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> save(
			@ApiParam(value = "system_param数据", required = true) @RequestBody SystemParam systemParam) {
    	systemParamService.save(systemParam);
		return new ResponseEntity<SystemParam>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除", notes="删除system_param数据",response = SystemParam.class, tags = { "system.param",})
    @RequestMapping(value="/delete/{systemParamCode}", method=RequestMethod.DELETE, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> delete(
			@ApiParam(value = "system_param数据code", required = true) @PathVariable String systemParamCode) {
		SystemParam oldSystemParam = systemParamRepository.findBySystemParamCode(systemParamCode);
		systemParamService.delete(oldSystemParam);
		return new ResponseEntity<SystemParam>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新", notes="更新system_param数据",response = SystemParam.class, tags = { "system.param",})
    @RequestMapping(value="/update", method=RequestMethod.PUT, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> update(
			@ApiParam(value = "system_param数据", required = true) @RequestBody SystemParam systemParam) {
		systemParamService.update(systemParam);
		return new ResponseEntity<SystemParam>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询", notes="查询system_param数据",response = SystemParam.class, tags = { "system.param",})
    @RequestMapping(value="/queryByCode/{systemParamCode}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "system_param数据code", required = true) @PathVariable String systemParamCode) {
		systemParamRepository.findBySystemParamCode(systemParamCode);
		return new ResponseEntity<SystemParam>(HttpStatus.OK);
	}
	
	@ApiOperation(value="数据分页查询", notes="查询system_param数据",response = ResponseDomain.class, tags = { "system.param",})
    @RequestMapping(value="/queryByPage", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryByPage(
			@ApiParam(value = "system_param查询条件") @RequestBody SystemParamView systemParamView) {
    	/*1. 数据校验*/
    	if(StringUtils.isBlank(systemParamView.getPageQueryBean()))systemParamView.setPageQueryBean(new PageQueryBean());
    	if(StringUtils.isBlank(systemParamView.getPageQueryBean().getPageNo()))systemParamView.getPageQueryBean().setPageNo(1);
    	if(StringUtils.isBlank(systemParamView.getPageQueryBean().getPageSize()))systemParamView.getPageQueryBean().setPageSize(10);
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("SystemParam");
    	/*3. 数据查询*/
    	List<SystemParam> list = baseQueryRepositoryImpl.queryByPageByJPQL(sql, SqlUtils.createParamValueList(), SystemParam.class, systemParamView.getPageQueryBean().getPageNo(), systemParamView.getPageQueryBean().getPageSize());
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), SystemParam.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(systemParamView.getPageQueryBean(), "systemParam.queryByPage",count);
		return ResponseManager.handerResponse(SystemParam.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
    @ApiOperation(value="数据查询所有", notes="查询system_param数据",response = ResponseDomain.class, tags = { "system.param",})
    @RequestMapping(value="/queryAll", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryAll(
			@ApiParam(value = "system_param查询条件") @RequestBody SystemParamView systemParamView) {
    	/*1. 数据校验*/
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("SystemParam");
    	/*3. 数据查询*/
    	List<SystemParam> list = baseQueryRepositoryImpl.queryAllByJPQL(sql, SqlUtils.createParamValueList(), SystemParam.class);
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), SystemParam.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(systemParamView.getPageQueryBean(), "systemParam.queryByPage",count);
		return ResponseManager.handerResponse(SystemParam.class,null, list, HttpStatus.OK, "成功获取数据列表", null, pageTools);
	}
    
	public SystemParamService getSystemParamService() {
		return systemParamService;
	}
	public void setSystemParamService(SystemParamService systemParamService) {
		this.systemParamService = systemParamService;
	}
	public BaseQueryRepositoryImpl<SystemParam, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<SystemParam, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public SystemParamRepository getSystemParamRepository() {
		return systemParamRepository;
	}
	public void setSystemParamRepository(SystemParamRepository systemParamRepository) {
		this.systemParamRepository = systemParamRepository;
	}   
}
