package test;

import com.blog.interceptor.BundlingMethod;
import com.blog.interceptor.BundlingProxy;
import com.blog.interceptor.InterceptorMethod;
/**
 * ≤‚ ‘∂ØÃ¨¥˙¿Ì
 * @author duanjigui
 *@time 2016/5/15
 */
public class Test {
	public static void main(String[] args) {
		BundlingMethod method=new Apple();
		InterceptorMethod interceptor=new MyInterceptor();
		BundlingProxy proxy=new BundlingProxy(method, interceptor);
		BundlingMethod method2=	(BundlingMethod) proxy.getObject();	
		method2.bundleMethod();
	}
}
