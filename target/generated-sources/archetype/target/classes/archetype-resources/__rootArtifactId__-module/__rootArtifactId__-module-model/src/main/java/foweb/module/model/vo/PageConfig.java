#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.foweb.module.model.vo;

import java.io.Serializable;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016-09-07
 */
public class PageConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 862394223766206144L;

	private int pageIndex;	//数据库检索起始位置
	private int rowCount; // 总记录数

	private int pageSize = 10; // 每页显示记录

	private int pageNum = 1; // 当前页号

	private int pageCount; // 总页

	private String orderBy; // order by 子句

	public PageConfig() {
		super();
	}
	
	public void init(){
		if(pageIndex==0){
			pageIndex = (pageNum-1)*pageSize;
		}
	}
	public void initPages(Integer totalRows) {
		rowCount = totalRows;
		pageCount = (rowCount % pageSize) == 0 ? (rowCount/pageSize):(rowCount/pageSize)+1;
	}
	public PageConfig(int rowCount, int pageSize, int pageNum, int pageCount,
			int currRowNum, int startIndex, int endIndex, int pageCode,
			int nextPage, int previousPage, String orderBy) {
		super();
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.pageCount = pageCount;
		this.orderBy = orderBy;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowCount() {
		/*
		 * if (PageHelp.getTotalElements() != null) { rowCount =
		 * PageHelp.getTotalElements(); PageHelp.clean(); }
		 */
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount; // 计算总页

		// getPageIndex(pageCode, pageNum, pageCount); // 计算结束索引
	}

	public int getPageNum() {
		if (pageNum < 1)
			pageNum = pageIndex + 1;
		// if(pageIndex)
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public String toString() {
		return "PageConfig [pageIndex=" + pageIndex + ", rowCount=" + rowCount
				+ ", pageSize=" + pageSize + ", pageNum=" + pageNum
				+ ", pageCount=" + pageCount + ", orderBy=" + orderBy + "]";
	}

	

}
