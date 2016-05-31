package test;

import com.blog.interceptor.InterceptorMethod;
/**
 * 测试增加的拦截方法
 * @author duanjigui
 *@time 2016/5/15
 */
public class MyInterceptor implements InterceptorMethod {

	@Override
	public void before() {
		System.out.println("之前");
	}

	@Override
	public void after() {
		System.out.println("之后");
	}

}
