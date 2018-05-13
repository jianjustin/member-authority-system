package org.jerry.light4j.member.business.member.resource.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：member_resource模型
* @author tools
*/
@Entity
@Table(name="member_resource")
public class MemberResource{
	
    /**
    *主键ID
    */
	@Id
    @Column(name = "PK_ID",columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *资源编号
    */
    @Column(name = "MEMBER_RESOURCE_CODE",columnDefinition = "varchar")
    private String memberResourceCode;
    /**
    *资源名称
    */
    @Column(name = "MEMBER_RESOURCE_NAME",columnDefinition = "varchar")
    private String memberResourceName;
    /**
    *资源类型
    */
    @Column(name = "MEMBER_RESOURCE_TYPE",columnDefinition = "varchar")
    private String memberResourceType;
    /**
    *资源路由
    */
    @Column(name = "MEMBER_RESOURCE_ROUTER",columnDefinition = "varchar")
    private String memberResourceRouter;
    /**
    *资源备注
    */
    @Column(name = "MEMBER_RESOURCE_REMARK",columnDefinition = "varchar")
    private String memberResourceRemark;
    /**
    *记录创建时间
    */
    @Column(name = "MEMBER_RESOURCE_CREATE_DATE",columnDefinition = "datetime")
    private Date memberResourceCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "MEMBER_RESOURCE_ORDER_BY",columnDefinition = "varchar")
    private String memberResourceOrderBy;

    public String getmemberResourceCode() {
        return this.memberResourceCode;
    }
    public void setmemberResourceCode(String memberResourceCode) {
        this.memberResourceCode = memberResourceCode;
    }
	
    public String getmemberResourceName() {
        return this.memberResourceName;
    }
    public void setmemberResourceName(String memberResourceName) {
        this.memberResourceName = memberResourceName;
    }
	
    public String getmemberResourceType() {
        return this.memberResourceType;
    }
    public void setmemberResourceType(String memberResourceType) {
        this.memberResourceType = memberResourceType;
    }
	
    public String getmemberResourceRouter() {
        return this.memberResourceRouter;
    }
    public void setmemberResourceRouter(String memberResourceRouter) {
        this.memberResourceRouter = memberResourceRouter;
    }
	
    public String getmemberResourceRemark() {
        return this.memberResourceRemark;
    }
    public void setmemberResourceRemark(String memberResourceRemark) {
        this.memberResourceRemark = memberResourceRemark;
    }
	
    public String getmemberResourceOrderBy() {
        return this.memberResourceOrderBy;
    }
    public void setmemberResourceOrderBy(String memberResourceOrderBy) {
        this.memberResourceOrderBy = memberResourceOrderBy;
    }
	
}