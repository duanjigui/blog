package com.blog.interceptor;
/**
 * <p>包装类方法，专供生成代理,对底层具体的实现细节进行封装</p>
 * <p>获取代理类时，建议使用此方法</p>
 * @author duanjigui
 *@data 2016/5/14
 *@version 1.0
 */
public class BundlingProxy extends ProxyGeneration {
	//给父类的两个参数赋值
	public BundlingProxy(BundlingMethod object, InterceptorMethod interceptor) {
		super.setObject(object);
		super.setInterceptor(interceptor);
	}
	public Object getObject() {
		return super.getProxy();
	}
	//提供可以重新设置绑定方法
	public void setObject(BundlingMethod object) {
		super.setObject(object);
	}

	//提供可以重新设置绑定方法之前或之后实现的方法
	public void setInterceptor(InterceptorMethod interceptor) {
		super.setInterceptor(interceptor);
	}

}
