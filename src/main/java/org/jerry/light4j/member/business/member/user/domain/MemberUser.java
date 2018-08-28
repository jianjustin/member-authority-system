package org.jerry.light4j.member.business.member.user.domain;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

/**
* 描述：member_user模型
* @author tools
*/
@DynamicUpdate
@Entity
@Table(name="member_user")
@Component
public class MemberUser{
	
    /**
    *自增列
    */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID",columnDefinition = "bigint")
    private Long pkId;
    /**
    *用户编号
    */
    @Column(name = "MEMBER_USER_CODE",columnDefinition = "varchar")
    private String memberUserCode;
    /**
    *用户名称
    */
    @Column(name = "MEMBER_USER_NAME",columnDefinition = "varchar")
    private String memberUserName;
    /**
    *用户账号
    */
    @Column(name = "MEMBER_USER_LOGIN_ACCOUNT",columnDefinition = "varchar")
    private String memberUserLoginAccount;
    /**
    *用户手机号
    */
    @Column(name = "MEMBER_USER_PHONE_NUMBER",columnDefinition = "varchar")
    private String memberUserPhoneNumber;
    /**
    *用户邮箱
    */
    @Column(name = "MEMBER_USER_EMAIL",columnDefinition = "varchar")
    private String memberUserEmail;
    /**
    *用户登陆密码
    */
    @Column(name = "MEMBER_USER_LOGIN_PASSWORD",columnDefinition = "varchar")
    private String memberUserLoginPassword;
    /**
    *用户最后登陆时间
    */
    @Column(name = "MEMBER_USER_CREATE_DATE",columnDefinition = "date")
    private Date memberUserCreateDate;
    /**
    *用户角色编号
    */
    @Column(name = "MEMBER_USER_ROLE_CODE",columnDefinition = "varchar")
    private String memberUserRoleCode;
    /**
    *用户排序编号
    */
    @Column(name = "MEMBER_USER_ORDER_BY",columnDefinition = "varchar")
    private String memberUserOrderBy;
    /**
     *用户ClientId
     */
     @Column(name = "MEMBER_USER_CLIENT_ID",columnDefinition = "varchar")
     private String memberUserClientId;
     /**
      *用户ClientSecret
      */
     @Column(name = "MEMBER_USER_CLIENT_SECRET",columnDefinition = "varchar")
     private String memberUserClientSecret;
     /**
      *用户RedirectUri
      */
     @Column(name = "MEMBER_USER_REDIRECT_URI",columnDefinition = "varchar")
     private String memberUserRedirectUri;

	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	public String getMemberUserCode() {
		return memberUserCode;
	}
	public void setMemberUserCode(String memberUserCode) {
		this.memberUserCode = memberUserCode;
	}
	public String getMemberUserName() {
		return memberUserName;
	}
	public void setMemberUserName(String memberUserName) {
		this.memberUserName = memberUserName;
	}
	public String getMemberUserLoginAccount() {
		return memberUserLoginAccount;
	}
	public void setMemberUserLoginAccount(String memberUserLoginAccount) {
		this.memberUserLoginAccount = memberUserLoginAccount;
	}
	public String getMemberUserEmail() {
		return memberUserEmail;
	}
	public void setMemberUserEmail(String memberUserEmail) {
		this.memberUserEmail = memberUserEmail;
	}
	public String getMemberUserLoginPassword() {
		return memberUserLoginPassword;
	}
	public void setMemberUserLoginPassword(String memberUserLoginPassword) {
		this.memberUserLoginPassword = memberUserLoginPassword;
	}
	public String getMemberUserRoleCode() {
		return memberUserRoleCode;
	}
	public void setMemberUserRoleCode(String memberUserRoleCode) {
		this.memberUserRoleCode = memberUserRoleCode;
	}
	public String getMemberUserPhoneNumber() {
		return memberUserPhoneNumber;
	}
	public void setMemberUserPhoneNumber(String memberUserPhoneNumber) {
		this.memberUserPhoneNumber = memberUserPhoneNumber;
	}
	public Date getMemberUserCreateDate() {
		return memberUserCreateDate;
	}
	public void setMemberUserCreateDate(Date memberUserCreateDate) {
		this.memberUserCreateDate = memberUserCreateDate;
	}
	public String getMemberUserOrderBy() {
		return memberUserOrderBy;
	}
	public void setMemberUserOrderBy(String memberUserOrderBy) {
		this.memberUserOrderBy = memberUserOrderBy;
	}
	public String getMemberUserClientId() {
		return memberUserClientId;
	}
	public void setMemberUserClientId(String memberUserClientId) {
		this.memberUserClientId = memberUserClientId;
	}
	public String getMemberUserClientSecret() {
		return memberUserClientSecret;
	}
	public void setMemberUserClientSecret(String memberUserClientSecret) {
		this.memberUserClientSecret = memberUserClientSecret;
	}
	public String getMemberUserRedirectUri() {
		return memberUserRedirectUri;
	}
	public void setMemberUserRedirectUri(String memberUserRedirectUri) {
		this.memberUserRedirectUri = memberUserRedirectUri;
	}
	
	
    
	
}