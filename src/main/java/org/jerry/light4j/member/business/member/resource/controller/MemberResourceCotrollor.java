package org.jerry.light4j.member.business.member.resource.controller;

import java.io.Serializable;

import org.jerry.light4j.member.business.member.resource.domain.MemberResource;
import org.jerry.light4j.member.business.member.resource.repository.MemberResourceRepository;
import org.jerry.light4j.member.business.member.resource.service.MemberResourceService;
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
@RequestMapping("/member/resource")
public class MemberResourceCotrollor{
    @Autowired
	private MemberResourceService memberResourceService;
    @Autowired
    private BaseQueryRepositoryImpl<MemberResource, Serializable> baseQueryRepositoryImpl;
    @Autowired
	private MemberResourceRepository memberResourceRepository;
    
    @ApiOperation(value="数据插入", notes="创建member_resource数据",response = MemberResource.class, tags = { "member.resource",})
    @RequestMapping(value="/save", method=RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> save(
			@ApiParam(value = "member_resource数据", required = true) @RequestBody MemberResource memberResource) {
    	memberResourceService.save(memberResource);
		return new ResponseEntity<MemberResource>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据删除", notes="删除member_resource数据",response = MemberResource.class, tags = { "member.resource",})
    @RequestMapping(value="/delete/{memberResourceCode}", method=RequestMethod.DELETE, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> delete(
			@ApiParam(value = "member_resource数据code", required = true) @PathVariable String memberResourceCode) {
		MemberResource oldMemberResource = memberResourceRepository.findByMemberResourceCode(memberResourceCode);
		memberResourceService.delete(oldMemberResource);
		return new ResponseEntity<MemberResource>(HttpStatus.OK);
	}
    
    @ApiOperation(value="数据更新", notes="更新member_resource数据",response = MemberResource.class, tags = { "member.resource",})
    @RequestMapping(value="/update", method=RequestMethod.PUT, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/json"})
	public ResponseEntity<?> update(
			@ApiParam(value = "member_resource数据", required = true) @RequestBody MemberResource memberResource) {
		memberResourceService.update(memberResource);
		return new ResponseEntity<MemberResource>(HttpStatus.OK);
	}
	
    @ApiOperation(value="数据查询", notes="查询member_resource数据",response = MemberResource.class, tags = { "member.resource",})
    @RequestMapping(value="/queryByCode/{memberResourceCode}", method=RequestMethod.GET, produces = "application/json; charset=UTF-8", consumes = {"text/plain", "application/*"})
    public ResponseEntity<?> queryByCode(
			@ApiParam(value = "member_resource数据code", required = true) @PathVariable String memberResourceCode) {
		memberResourceRepository.findByMemberResourceCode(memberResourceCode);
		return new ResponseEntity<MemberResource>(HttpStatus.OK);
	}
    
	public MemberResourceService getMemberResourceService() {
		return memberResourceService;
	}
	public void setMemberResourceService(MemberResourceService memberResourceService) {
		this.memberResourceService = memberResourceService;
	}
	public BaseQueryRepositoryImpl<MemberResource, Serializable> getBaseQueryRepositoryImpl() {
		return baseQueryRepositoryImpl;
	}
	public void setBaseQueryRepositoryImpl(
			BaseQueryRepositoryImpl<MemberResource, Serializable> baseQueryRepositoryImpl) {
		this.baseQueryRepositoryImpl = baseQueryRepositoryImpl;
	}
	public MemberResourceRepository getMemberResourceRepository() {
		return memberResourceRepository;
	}
	public void setMemberResourceRepository(MemberResourceRepository memberResourceRepository) {
		this.memberResourceRepository = memberResourceRepository;
	}   
}
