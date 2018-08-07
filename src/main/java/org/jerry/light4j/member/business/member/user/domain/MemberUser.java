package org.jerry.light4j.member.business.member.user.domain;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* 描述：member_user模型
* @author tools
*/
@DynamicUpdate
@Entity
@Table(name="member_user")
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
    *用户tokenid
    */
    @Column(name = "MEMBER_USER_TOKEN_ID",columnDefinition = "varchar")
    private String memberUserToken_Id;
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
	public String getMemberUserToken_Id() {
		return memberUserToken_Id;
	}
	public void setMemberUserToken_Id(String memberUserToken_Id) {
		this.memberUserToken_Id = memberUserToken_Id;
	}
	
    
	
}