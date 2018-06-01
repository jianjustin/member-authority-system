package org.jerry.light4j.member.common.session;

import java.util.List;
import java.util.Map;

import org.jerry.light4j.member.business.member.authority.domain.MemberAuthority;
import org.jerry.light4j.member.business.member.resource.domain.MemberResource;
import org.jerry.light4j.member.business.member.role.domain.MemberRole;
import org.jerry.light4j.member.business.member.user.domain.MemberUser;

/**
 * session数据集
 * @author admin
 *
 */
public class UserSession {

	private String host;
	private String port;
	private MemberUser memberUser;
	private MemberRole memberRole;
	private List<MemberAuthority> memberAuthoritys;
	private Map<String,MemberAuthority> memberAuthorityMap;
	private List<MemberResource> memberResources;
	private Map<String,MemberResource> memberResourceMap;
	private String sessionId;
	private String tokenid;
	private Map<String,Object> attrs;
	
	/**
	 * 设置权限路由集
	 */
	private void putResourceMap(){
		memberResourceMap.clear();
		for (MemberResource memberResource : memberResources) {
			memberResourceMap.put(memberResource.getmemberResourceRouter(), memberResource);
		}
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public MemberUser getMemberUser() {
		return memberUser;
	}
	public void setMemberUser(MemberUser memberUser) {
		this.memberUser = memberUser;
	}
	public MemberRole getMemberRole() {
		return memberRole;
	}
	public void setMemberRole(MemberRole memberRole) {
		this.memberRole = memberRole;
	}
	public List<MemberAuthority> getMemberAuthoritys() {
		return memberAuthoritys;
	}
	public void setMemberAuthoritys(List<MemberAuthority> memberAuthoritys) {
		this.memberAuthoritys = memberAuthoritys;
	}
	public Map<String, MemberAuthority> getMemberAuthorityMap() {
		return memberAuthorityMap;
	}
	public void setMemberAuthorityMap(Map<String, MemberAuthority> memberAuthorityMap) {
		this.memberAuthorityMap = memberAuthorityMap;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getTokenid() {
		return tokenid;
	}
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}
	public Map<String, Object> getAttrs() {
		return attrs;
	}
	public void setAttrs(Map<String, Object> attrs) {
		this.attrs = attrs;
	}
	public List<MemberResource> getMemberResources() {
		return memberResources;
	}
	public void setMemberResources(List<MemberResource> memberResources) {
		this.memberResources = memberResources;
		putResourceMap();
	}
	public Map<String, MemberResource> getMemberResourceMap() {
		return memberResourceMap;
	}
	public void setMemberResourceMap(Map<String, MemberResource> memberResourceMap) {
		this.memberResourceMap = memberResourceMap;
	}
	
	
}
