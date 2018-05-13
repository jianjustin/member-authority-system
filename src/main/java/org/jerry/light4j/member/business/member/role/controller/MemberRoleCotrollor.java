package org.jerry.light4j.member.business.member.role.controller;

import java.io.Serializable;

import org.jerry.light4j.member.business.member.role.domain.MemberRole;
import org.jerry.light4j.member.business.member.role.repository.MemberRoleRepository;
import org.jerry.light4j.member.business.member.role.service.MemberRoleService;
import org.jerry.light4j.member.common.base.repository.impl.BaseQueryRepositoryImpl;
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
@RequestMapping("/member/role")
public class MemberRoleCotrollor{
    @Autowired
	private MemberRoleService memberRoleService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberRole, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberRoleRepository memberRoleRepository;
    
    @ApiOperation(value="数据插入", notes="创建member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/save", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> save(
			@ApiParam(value = "member_role数据", required = true) @RequestBody MemberRole memberRole) {
    	memberRoleService.save(memberRole);
		return new ResponseEntity<MemberRole>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除", notes="删除member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/delete/{memberRoleCode}", method=RequestMethod.DELETE, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_role数据code", required = true) @PathVariable String memberRoleCode) {
		MemberRole oldMemberRole = memberRoleRepository.findByMemberRoleCode(memberRoleCode);
		memberRoleService.delete(oldMemberRole);
		return new ResponseEntity<MemberRole>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新", notes="更新member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/update", method=RequestMethod.PUT, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> update(
			@ApiParam(value = "member_role数据", required = true) @RequestBody MemberRole memberRole) {
		memberRoleService.update(memberRole);
		return new ResponseEntity<MemberRole>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询", notes="查询member_role数据",response = MemberRole.class, tags = { "member.role",})
    @RequestMapping(value="/queryByCode/{memberRoleCode}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_role数据code", required = true) @PathVariable String memberRoleCode) {
		memberRoleRepository.findByMemberRoleCode(memberRoleCode);
		return new ResponseEntity<MemberRole>(HttpStatus.OK);
	}
    
	public MemberRoleService getMemberRoleService() {
		return memberRoleService;
	}
	public void setMemberRoleService(MemberRoleService memberRoleService) {
		this.memberRoleService = memberRoleService;
	}
	public BaseQueryRepositoryImpl<MemberRole, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberRole, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public MemberRoleRepository getMemberRoleRepository() {
		return memberRoleRepository;
	}
	public void setMemberRoleRepository(MemberRoleRepository memberRoleRepository) {
		this.memberRoleRepository = memberRoleRepository;
	}   
}
