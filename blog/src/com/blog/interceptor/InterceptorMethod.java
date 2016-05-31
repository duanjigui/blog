package com.blog.interceptor;
/**
 * <p>在拦截的方法之前或之后所要执行的方法</p>
 * <p>如果想要实现拦截器，只需要实现该接口或者继承该接口进行扩展即可</p>
 * @author duanjigui
 *@data 2016/5/14
 */

public interface InterceptorMethod {
		//在绑定的方法之前执行
		public void before();
		//在绑定的方法之后执行
		public void after();
}
