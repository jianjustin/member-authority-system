package org.jerry.light4j.member.business.member.resource.domain;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

/**
* 描述：member_resource模型(用于视图层处理)
* @author tools
*/
public class MemberResourceData{
	
    /**
    *主键ID
    */
    private Long pkId;
    /**
    *资源编号
    */
    private String memberResourceCode;
    /**
     *资源编号
     */
     private String memberResourceParentCode;
    /**
    *资源名称
    */
    private String memberResourceName;
    /**
    *资源类型
    */
    private String memberResourceType;
    /**
    *资源路由
    */
    private String memberResourceRouter;
    /**
    *资源备注
    */
    private String memberResourceRemark;
    /**
    *记录创建时间
    */
    private Date memberResourceCreateDate;
    /**
    *记录排序号
    */
    private String memberResourceOrderBy;
    
    @ApiModelProperty(position=1, value="主键ID", example="1")
	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	@ApiModelProperty(position=2, value="资源编号", example="00000000")
	public String getMemberResourceCode() {
		return memberResourceCode;
	}
	public void setMemberResourceCode(String memberResourceCode) {
		this.memberResourceCode = memberResourceCode;
	}
	@ApiModelProperty(position=3, value="资源父节点编号", example="00000001")
	public String getMemberResourceParentCode() {
		return memberResourceParentCode;
	}
	public void setMemberResourceParentCode(String memberResourceParentCode) {
		this.memberResourceParentCode = memberResourceParentCode;
	}
	@ApiModelProperty(position=4, value="资源名称", example="一级菜单")
	public String getMemberResourceName() {
		return memberResourceName;
	}
	public void setMemberResourceName(String memberResourceName) {
		this.memberResourceName = memberResourceName;
	}
	@ApiModelProperty(position=5, value="资源类型", example="0")
	public String getMemberResourceType() {
		return memberResourceType;
	}
	public void setMemberResourceType(String memberResourceType) {
		this.memberResourceType = memberResourceType;
	}
	@ApiModelProperty(position=6, value="资源路由配置", example="/shouye")
	public String getMemberResourceRouter() {
		return memberResourceRouter;
	}
	public void setMemberResourceRouter(String memberResourceRouter) {
		this.memberResourceRouter = memberResourceRouter;
	}
	@ApiModelProperty(position=7, value="资源备注", example="资源备注")
	public String getMemberResourceRemark() {
		return memberResourceRemark;
	}
	public void setMemberResourceRemark(String memberResourceRemark) {
		this.memberResourceRemark = memberResourceRemark;
	}
	@ApiModelProperty(position=3, value="资源记录创建时间", example="2015-08-01")
	public Date getMemberResourceCreateDate() {
		return memberResourceCreateDate;
	}
	public void setMemberResourceCreateDate(Date memberResourceCreateDate) {
		this.memberResourceCreateDate = memberResourceCreateDate;
	}
	@ApiModelProperty(position=3, value="资源记录排序号", example="1")
	public String getMemberResourceOrderBy() {
		return memberResourceOrderBy;
	}
	public void setMemberResourceOrderBy(String memberResourceOrderBy) {
		this.memberResourceOrderBy = memberResourceOrderBy;
	}
    
    
}