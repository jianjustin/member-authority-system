package org.jerry.light4j.member.business.system.param.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* 描述：system_param模型
* @author tools
*/
@Entity
@Table(name="system_param")
public class SystemParam{
	
    /**
    *主键ID
    */
	@Id
    @Column(name = "PK_ID",columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    /**
    *系统字典记录编号
    */
    @Column(name = "SYSTEM_PARAM_CODE",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String systemParamCode;
    /**
    *字典key编号
    */
    @Column(name = "SYSTEM_PARAM_KEY_CODE",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String systemParamKeyCode;
    /**
    *字典key名称
    */
    @Column(name = "SYSTEM_PARAM_KEY_NAME",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String systemParamKeyName;
    /**
    *字典value编号
    */
    @Column(name = "SYSTEM_PARAM_VALUE_CODE",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String systemParamValueCode;
    /**
    *字典value名称
    */
    @Column(name = "SYSTEM_PARAM_VALUE_NAME",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String systemParamValueName;
    /**
    *记录创建时间
    */
    @Column(name = "SYSTEM_PARAM_CREATE_DATE",columnDefinition = "DATE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date systemParamCreateDate;
    /**
    *记录排序号
    */
    @Column(name = "SYSTEM_PARAM_ORDER_BY",columnDefinition = "VARCHAR2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String systemParamOrderBy;
	public Long getPkId() {
		return pkId;
	}
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	public String getSystemParamCode() {
		return systemParamCode;
	}
	public void setSystemParamCode(String systemParamCode) {
		this.systemParamCode = systemParamCode;
	}
	public String getSystemParamKeyCode() {
		return systemParamKeyCode;
	}
	public void setSystemParamKeyCode(String systemParamKeyCode) {
		this.systemParamKeyCode = systemParamKeyCode;
	}
	public String getSystemParamKeyName() {
		return systemParamKeyName;
	}
	public void setSystemParamKeyName(String systemParamKeyName) {
		this.systemParamKeyName = systemParamKeyName;
	}
	public String getSystemParamValueCode() {
		return systemParamValueCode;
	}
	public void setSystemParamValueCode(String systemParamValueCode) {
		this.systemParamValueCode = systemParamValueCode;
	}
	public String getSystemParamValueName() {
		return systemParamValueName;
	}
	public void setSystemParamValueName(String systemParamValueName) {
		this.systemParamValueName = systemParamValueName;
	}
	public Date getSystemParamCreateDate() {
		return systemParamCreateDate;
	}
	public void setSystemParamCreateDate(Date systemParamCreateDate) {
		this.systemParamCreateDate = systemParamCreateDate;
	}
	public String getSystemParamOrderBy() {
		return systemParamOrderBy;
	}
	public void setSystemParamOrderBy(String systemParamOrderBy) {
		this.systemParamOrderBy = systemParamOrderBy;
	}

    
    
}