package org.jerry.light4j.member.business.member.authority.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：member_authority模型
* @author tools
*/
@Entity
@Table(name="member_authority")
public class MemberAuthority{
	
    /**
    *主键ID
    */
	@Id
    @Column(name = "PK_ID",columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *权限对照编号
    */
    @Column(name = "MEMBER_AUTHORITY_CODE",columnDefinition = "varchar")
    private String memberAuthorityCode;
    /**
    *角色编号
    */
    @Column(name = "MEMBER_AUTHORITY_ROLE_CODE",columnDefinition = "varchar")
    private String memberAuthorityRoleCode;
    /**
    *资源编号
    */
    @Column(name = "MEMBER_AUTHORITY_RESOURCE_CODE",columnDefinition = "varchar")
    private String memberAuthorityResourceCode;
    /**
    *记录创建时间
    */
    @Column(name = "MEMBER_AUTHORITY_CREATE_DATE",columnDefinition = "datetime")
    private Date memberAuthorityCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "MEMBER_AUTHORITY_ORDER_BY",columnDefinition = "varchar")
    private String memberAuthorityOrderBy;

    public String getmemberAuthorityCode() {
        return this.memberAuthorityCode;
    }
    public void setmemberAuthorityCode(String memberAuthorityCode) {
        this.memberAuthorityCode = memberAuthorityCode;
    }
	
    public String getmemberAuthorityRoleCode() {
        return this.memberAuthorityRoleCode;
    }
    public void setmemberAuthorityRoleCode(String memberAuthorityRoleCode) {
        this.memberAuthorityRoleCode = memberAuthorityRoleCode;
    }
	
    public String getmemberAuthorityResourceCode() {
        return this.memberAuthorityResourceCode;
    }
    public void setmemberAuthorityResourceCode(String memberAuthorityResourceCode) {
        this.memberAuthorityResourceCode = memberAuthorityResourceCode;
    }
	
    public String getmemberAuthorityOrderBy() {
        return this.memberAuthorityOrderBy;
    }
    public void setmemberAuthorityOrderBy(String memberAuthorityOrderBy) {
        this.memberAuthorityOrderBy = memberAuthorityOrderBy;
    }
	
}