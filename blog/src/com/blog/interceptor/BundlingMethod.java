package com.blog.interceptor;
/**
 * <p>创建一个动态AOP中需要被绑定的方法</p>
 * <p>如果需要扩展该方法，只需要创建一个接口去继承该接口</p>
 * @author duanjigui
 * @data: 2016/5/14
 *@version 1.0
 */
public interface BundlingMethod {
	//待绑定的方法
			public void bundleMethod();
}
