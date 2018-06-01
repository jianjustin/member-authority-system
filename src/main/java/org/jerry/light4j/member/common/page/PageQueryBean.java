package org.jerry.light4j.member.common.page;

/**
 * 分页查询参数实体
 * @author jian
 *
 */
public class PageQueryBean {

	/**
	 * 分页起始位置
	 */
	private int offset;
	/**
	 * 分页数据条数
	 */
	private int pageSize;
	/**
	 * 分页页码
	 */
	private int pageNo;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
