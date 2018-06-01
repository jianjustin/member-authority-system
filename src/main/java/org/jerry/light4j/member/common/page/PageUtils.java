package org.jerry.light4j.member.common.page;

/**
 * 分页参数构建实体
 * @author jian
 *
 */
public class PageUtils {
	
	/**
	 * 通过基本参数构建分页对象(数据总数需要单独调汇总接口)
	 * @param pageQueryBean
	 * @param actionURL
	 * @return
	 */
	public static PageTools buildPageTools(PageQueryBean pageQueryBean,String actionURL){
		pageQueryBean.setOffset((pageQueryBean.getPageNo()-1)*pageQueryBean.getPageSize());
		PageTools pageTools = new PageTools();
		pageTools.setPageNo(pageQueryBean.getPageNo());
		pageTools.setPageSize(pageQueryBean.getPageSize());
		pageTools.setPageSizeOptions("");
		pageTools.setRecordCount(0);
		pageTools.setRecordCountNo(pageQueryBean.getOffset());
		pageTools.setTotalPage(pageTools.getRecordCount()/pageTools.getPageSize());
		pageTools.setUrl(actionURL);
		return pageTools;
	}

}
