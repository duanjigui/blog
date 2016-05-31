package com.blog.bean;
/**
 * <p>此javabean用于记录页面信息,分页时会使用</p>
 * @author duanjigui
 *@time 2016/5/15
 *@version 1.0
 */
public class PageInfoBean {
	private int currentPage;  //当前属于第几页
	private int maxPage;  //所能分的最大页
	private int pageItem; //每页能存放信息的条数
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPageItem() {
		return pageItem;
	}
	public void setPageItem(int pageItem) {
		this.pageItem = pageItem;
	}
	
}
