package org.jerry.light4j.member.common.page;

/**
 * 分页实体
 * @author chenjianrui
 *
 */
public class PageTools {
	
	/** 页数据起始位置*/
	private int recordCountNo = 0;
	/** 页大小(默认为10)，一页几行，和recordCountNo组合使用 */
	private int pageSize = 10;
	/** 总记录数 */
	private int recordCount;
	/** 当前页码，默认为1 */
	private int pageNo = 1;
	/** 总共多少页  */
	private int totalPage;
	/** 翻页数据请求的url地址 */
	private String url = "";
	/** 点击一页几条的下拉可选项，以逗号分隔如：10,20,50,100,500 */
	private String pageSizeOptions = "";
	
	public int getRecordCountNo() {
		return recordCountNo;
	}
	public void setRecordCountNo(int recordCountNo) {
		this.recordCountNo = recordCountNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPageSizeOptions() {
		return pageSizeOptions;
	}
	public void setPageSizeOptions(String pageSizeOptions) {
		this.pageSizeOptions = pageSizeOptions;
	}
	
	

}
