package org.jerry.light4j.member.business.system.param.domain;
import java.util.Map;

import org.jerry.light4j.member.common.page.PageQueryBean;
import org.jerry.light4j.member.common.page.PageTools;

/**
* 描述：视图层实体数据封装
* @author tools
*/
public class SystemParamView extends SystemParam{
	
	private PageQueryBean pageQueryBean;
	private PageTools pageTools;
	private Map<String,Object> resultMap;
	public PageQueryBean getPageQueryBean() {
		return pageQueryBean;
	}
	public void setPageQueryBean(PageQueryBean pageQueryBean) {
		this.pageQueryBean = pageQueryBean;
	}
	public PageTools getPageTools() {
		return pageTools;
	}
	public void setPageTools(PageTools pageTools) {
		this.pageTools = pageTools;
	}
	public Map<String, Object> getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	
	
}