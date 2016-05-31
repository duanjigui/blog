package test;

import com.blog.interceptor.BundlingMethod;
/**
 * 测试拦截的类
 * @author duanjigui
 *@time 2016/5/15
 */
public class Apple implements BundlingMethod {

	@Override
	public void bundleMethod() {
		System.out.println("绑定的方法！");
	}

}
