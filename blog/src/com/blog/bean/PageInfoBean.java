package com.blog.bean;
/**
 * <p>��javabean���ڼ�¼ҳ����Ϣ,��ҳʱ��ʹ��</p>
 * @author duanjigui
 *@time 2016/5/15
 *@version 1.0
 */
public class PageInfoBean {
	private int currentPage;  //��ǰ���ڵڼ�ҳ
	private int maxPage;  //���ֵܷ����ҳ
	private int pageItem; //ÿҳ�ܴ����Ϣ������
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
