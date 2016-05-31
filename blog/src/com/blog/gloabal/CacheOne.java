package com.blog.gloabal;
import java.util.*;
/**
 * 自定义的缓存区  【一级缓存】
 * @author duanjigui
 *@time 2016/5/30
 */
public class CacheOne {
	
	private  List<Object> list=new Vector<>();  //缓存数组,线程安全
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
