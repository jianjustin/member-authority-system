package org.jerry.light4j.member.business.member.role.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：member_role模型
* @author tools
*/
@Entity
@Table(name="member_role")
public class MemberRole{
	
    /**
    *主键ID
    */
	@Id
    @Column(name = "PK_ID",columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *角色编号
    */
    @Column(name = "MEMBER_ROLE_CODE",columnDefinition = "varchar")
    private String memberRoleCode;
    /**
    *角色名称
    */
    @Column(name = "MEMBER_ROLE_NAME",columnDefinition = "varchar")
    private String memberRoleName;
    /**
    *记录创建时间
    */
    @Column(name = "MEMBER_ROLE_CREATE_DATE",columnDefinition = "datetime")
    private Date memberRoleCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "MEMBER_ROLE_ORDER_BY",columnDefinition = "varchar")
    private String memberRoleOrderBy;

    public String getmemberRoleCode() {
        return this.memberRoleCode;
    }
    public void setmemberRoleCode(String memberRoleCode) {
        this.memberRoleCode = memberRoleCode;
    }
	
    public String getmemberRoleName() {
        return this.memberRoleName;
    }
    public void setmemberRoleName(String memberRoleName) {
        this.memberRoleName = memberRoleName;
    }
	
    public String getmemberRoleOrderBy() {
        return this.memberRoleOrderBy;
    }
    public void setmemberRoleOrderBy(String memberRoleOrderBy) {
        this.memberRoleOrderBy = memberRoleOrderBy;
    }
	
}