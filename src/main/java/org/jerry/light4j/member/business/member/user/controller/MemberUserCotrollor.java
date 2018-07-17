package org.jerry.light4j.member.business.member.user.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.business.member.user.domain.MemberUser;
import org.jerry.light4j.member.business.member.user.domain.MemberUserView;
import org.jerry.light4j.member.business.member.user.repository.MemberUserRepository;
import org.jerry.light4j.member.business.member.user.service.MemberUserService;
import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
import org.jerry.light4j.member.common.cache.MemCacheManager;
import org.jerry.light4j.member.common.code.CodeUtils;
import org.jerry.light4j.member.common.page.PageQueryBean;
import org.jerry.light4j.member.common.page.PageTools;
import org.jerry.light4j.member.common.page.PageUtils;
import org.jerry.light4j.member.common.response.ResponseDomain;
import org.jerry.light4j.member.common.response.ResponseManager;
import org.jerry.light4j.member.common.session.UserSession;
import org.jerry.light4j.member.common.sql.SqlUtils;
import org.jerry.light4j.member.common.utils.MD5Utils;
import org.jerry.light4j.member.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@Controller
@RequestMapping("/member/user")
public class MemberUserCotrollor{
    @Autowired
	private MemberUserService memberUserService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberUserRepository memberUserRepository;
    
    private ResponseEntity<Map<String,Object>> responseEntity;
    
    @ApiOperation(value="用户登陆", notes="用户登陆",response = MemberUser.class, tags = { "member.user",})
    @RequestMapping(value="/login", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> login(
			@ApiParam(value = "实体数据", required = true) @PathVariable String client_id,
			@ApiParam(value = "用户数据", required = true) @RequestBody MemberUser memberUser) {
    	MemberUser oldMemberUser = memberUserRepository.findByMemberUserLoginAccountAndMemberUserLoginPassword(memberUser.getMemberUserLoginAccount(), memberUser.getMemberUserLoginPassword());
    	Map<String,Object> resultMap = new HashMap<String,Object>();
    	if(null == oldMemberUser){
    		ResponseManager.handerResponse(MemberUser.class,oldMemberUser, null, HttpStatus.OK, "用户登陆失败", null, null);
    	}else{
    		if(!client_id.equals(oldMemberUser.getMemberUserToken_Id())){
    			ResponseManager.handerResponse(MemberUser.class,oldMemberUser, null, HttpStatus.OK, "用户client_id异常,请联系管理员", null, null);
    		}else{
    			/*token创建(时间戳+client_id)*/
    			Date date = new Date();
    			String tokenid = MD5Utils.crypt(client_id + date.toString());
        		/*用户会话创建*/
    			Map<String,Object> dataMap = new HashMap<String, Object>();
    			UserSession userSession = new UserSession();
    			userSession.setTokenid(tokenid);
    			dataMap.put("MemberUser", oldMemberUser);
    			dataMap.put("UserSession", userSession);
    			MemCacheManager.push(tokenid, dataMap);
    		}
    	}
		return responseEntity;
	}
    
    @ApiOperation(value="用户注册", notes="用户注册",response = MemberUser.class, tags = { "member.user",})
    @RequestMapping(value="/register", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> register(
			@ApiParam(value = "用户数据", required = true) @RequestBody MemberUser memberUser) {
    	/*校验用户数据*/
    	if(StringUtils.isBlank(memberUser.getMemberUserLoginAccount()))
    		ResponseManager.handerResponse(MemberUser.class,null, null, HttpStatus.OK, "用户账号为空", null, null);
    	if(StringUtils.isBlank(memberUser.getMemberUserLoginPassword()))
    		ResponseManager.handerResponse(MemberUser.class,null, null, HttpStatus.OK, "用户密码为空", null, null);
    	memberUser.setMemberUserCode(CodeUtils.getCode(CodeUtils.queryMax(baseQueryRepositoryImpl, "memberUser", MemberUser.class)));
    	MemberUser oldMemberUser = memberUserService.save(memberUser);
    	return ResponseManager.handerResponse(MemberUser.class,oldMemberUser, null, HttpStatus.OK, "用户注册成功", null, null);
	}
    
    @ApiOperation(value="数据插入", notes="创建用户数据",response = MemberUser.class, tags = { "member.user",})
    @RequestMapping(value="/save", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> save(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser) {
    	memberUser.setMemberUserCode(CodeUtils.getCode(CodeUtils.queryMax(baseQueryRepositoryImpl, "memberUser", MemberUser.class)));
    	memberUserService.save(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除", notes="删除用户数据",response = MemberUser.class, tags = { "member.user",})
    @RequestMapping(value="/delete/{memberUserCode}", method=RequestMethod.DELETE, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> delete(
			@ApiParam(value = "实体数据", required = true) @PathVariable String memberUserCode) {
		MemberUser oldMemberUser = memberUserRepository.findByMemberUserCode(memberUserCode);
		memberUserService.delete(oldMemberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新", notes="更新用户数据",response = MemberUser.class, tags = { "member.user",})
    @RequestMapping(value="/update", method=RequestMethod.PUT, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> update(
			@ApiParam(value = "实体数据", required = true) @RequestBody MemberUser memberUser) {
		memberUserService.update(memberUser);
		return new ResponseEntity<MemberUser>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询", notes="查询用户数据",response = MemberUser.class, tags = { "member.user",})
    @RequestMapping(value="/queryByCode/{memberUserCode}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "实体数据", required = true) @PathVariable String memberUserCode) {
		MemberUser memberUser = memberUserRepository.findByMemberUserCode(memberUserCode);
		return ResponseManager.handerResponse(MemberUser.class,memberUser, null, HttpStatus.OK, "成功获取资源数据", null, null);
	}
    
    @ApiOperation(value="数据分页查询", notes="查询member_resource数据",response = ResponseDomain.class, tags = { "member.resource",})
    @RequestMapping(value="/queryByPage", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryByPage(
			@ApiParam(value = "member_resource查询条件") @RequestBody MemberUserView memberUserView) {
    	/*1. 数据校验*/
    	if(StringUtils.isBlank(memberUserView.getPageQueryBean()))memberUserView.setPageQueryBean(new PageQueryBean());
    	if(StringUtils.isBlank(memberUserView.getPageQueryBean().getPageNo()))memberUserView.getPageQueryBean().setPageNo(1);
    	if(StringUtils.isBlank(memberUserView.getPageQueryBean().getPageSize()))memberUserView.getPageQueryBean().setPageSize(10);
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberResource");
    	/*3. 数据查询*/
    	List<MemberUser> list = baseQueryRepositoryImpl.queryByPageByJPQL(sql, SqlUtils.createParamValueList(), MemberUser.class, memberUserView.getPageQueryBean().getPageNo(), memberUserView.getPageQueryBean().getPageSize());
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,  SqlUtils.createParamValueList(), MemberUser.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberUserView.getPageQueryBean(), "memberResource.queryByPage",count);
		return ResponseManager.handerResponse(MemberUser.class,null, list, HttpStatus.OK, "成功获取资源数据列表", null, pageTools);
	}
    
    @ApiOperation(value="数据查询所有", notes="查询member_user数据",response = ResponseDomain.class, tags = { "member.user",})
    @RequestMapping(value="/queryAll", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json; charset=UTF-8"})
    public ResponseEntity<?> queryAll(
			@ApiParam(value = "member_user查询条件") @RequestBody MemberUserView memberUserView) {
    	/*1. 数据校验*/
    	/*2. SQL组装*/
    	String sql = SqlUtils.getInitSql("MemberUser");
    	/*3. 数据查询*/
    	List<MemberUser> list = baseQueryRepositoryImpl.queryAllByJPQL(sql,  SqlUtils.createParamValueList(), MemberUser.class);
    	/*4. 数据总量查询*/
    	int count = baseQueryRepositoryImpl.queryCountByJPQL(sql,SqlUtils.createParamValueList(), MemberUser.class);
		/*5. 封装返回信息*/
    	PageTools pageTools = PageUtils.buildPageTools(memberUserView.getPageQueryBean(), "memberResource.queryByPage",count);
		return ResponseManager.handerResponse(MemberUser.class,null, list, HttpStatus.OK, "成功获取资源数据列表", null, pageTools);
	}
   
    
    
    
	public MemberUserService getMemberUserService() {
		return memberUserService;
	}
	public void setMemberUserService(MemberUserService memberUserService) {
		this.memberUserService = memberUserService;
	}
	public BaseQueryRepositoryImpl<MemberUser, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberUser, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public MemberUserRepository getMemberUserRepository() {
		return memberUserRepository;
	}
	public void setMemberUserRepository(MemberUserRepository memberUserRepository) {
		this.memberUserRepository = memberUserRepository;
	}   
}
