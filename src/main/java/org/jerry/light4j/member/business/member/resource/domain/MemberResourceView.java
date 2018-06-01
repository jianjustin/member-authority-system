package org.jerry.light4j.member.business.member.resource.domain;
import java.util.Map;

import org.jerry.light4j.member.common.page.PageQueryBean;
import org.jerry.light4j.member.common.page.PageTools;

/**
* 描述：视图层实体
* @author tools
*/
public class MemberResourceView extends MemberResource{
	
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