package test;

import com.blog.interceptor.InterceptorMethod;
/**
 * �������ӵ����ط���
 * @author duanjigui
 *@time 2016/5/15
 */
public class MyInterceptor implements InterceptorMethod {

	@Override
	public void before() {
		System.out.println("֮ǰ");
	}

	@Override
	public void after() {
		System.out.println("֮��");
	}

}
