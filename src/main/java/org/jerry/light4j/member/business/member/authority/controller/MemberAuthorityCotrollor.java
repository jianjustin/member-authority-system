package org.jerry.light4j.member.business.member.authority.controller;

import java.io.Serializable;

import org.jerry.light4j.member.business.member.authority.domain.MemberAuthority;
import org.jerry.light4j.member.business.member.authority.repository.MemberAuthorityRepository;
import org.jerry.light4j.member.business.member.authority.service.MemberAuthorityService;
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
@RequestMapping("/member/authority")
public class MemberAuthorityCotrollor{
    @Autowired
	private MemberAuthorityService memberAuthorityService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberAuthority, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberAuthorityRepository memberAuthorityRepository;
    
    @ApiOperation(value="数据插入", notes="创建member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/save", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
	public ResponseEntity<?> save(
			@ApiParam(value = "member_authority数据", required = true) @RequestBody MemberAuthority memberAuthority) {
    	memberAuthorityService.save(memberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除", notes="删除member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/delete/{memberAuthorityCode}", method=RequestMethod.DELETE, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_authority数据code", required = true) @PathVariable String memberAuthorityCode) {
		MemberAuthority oldMemberAuthority = memberAuthorityRepository.findByMemberAuthorityCode(memberAuthorityCode);
		memberAuthorityService.delete(oldMemberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新", notes="更新member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/update", method=RequestMethod.PUT, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
	public ResponseEntity<?> update(
			@ApiParam(value = "member_authority数据", required = true) @RequestBody MemberAuthority memberAuthority) {
		memberAuthorityService.update(memberAuthority);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询", notes="查询member_authority数据",response = MemberAuthority.class, tags = { "member.authority",})
    @RequestMapping(value="/queryByCode/{memberAuthorityCode}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_authority数据code", required = true) @PathVariable String memberAuthorityCode) {
		memberAuthorityRepository.findByMemberAuthorityCode(memberAuthorityCode);
		return new ResponseEntity<MemberAuthority>(HttpStatus.OK);
	}
    
	public MemberAuthorityService getMemberAuthorityService() {
		return memberAuthorityService;
	}
	public void setMemberAuthorityService(MemberAuthorityService memberAuthorityService) {
		this.memberAuthorityService = memberAuthorityService;
	}
	public BaseQueryRepositoryImpl<MemberAuthority, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberAuthority, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public MemberAuthorityRepository getMemberAuthorityRepository() {
		return memberAuthorityRepository;
	}
	public void setMemberAuthorityRepository(MemberAuthorityRepository memberAuthorityRepository) {
		this.memberAuthorityRepository = memberAuthorityRepository;
	}   
}
