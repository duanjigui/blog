package com.blog.gloabal;
import java.util.*;
/**
 * �Զ���Ļ�����  ��һ�����桿
 * @author duanjigui
 *@time 2016/5/30
 */
public class CacheOne {
	
	private  List<Object> list=new Vector<>();  //��������,�̰߳�ȫ
	private static CacheOne cacheOne=null;
	private CacheOne(){
		
	}
	
	public void add(Object value){
		list.add(value);
	}
	public int getLength(){
		return list.size();
	}
	public void remove(Object value){
		list.remove(value);
	}
	
	public List<Object> getList(){
		return list;
	}
	
	public synchronized static CacheOne getCache() {
			if (null== cacheOne) {
				cacheOne=new CacheOne();
			}
			return cacheOne;
	}
	
}
