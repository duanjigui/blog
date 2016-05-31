package com.blog.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyGeneration implements InvocationHandler {
	//需要绑定的对象，限定为BoldMethod类型
		protected BundlingMethod object;
		//需要绑定执行方法的对象
		protected InterceptorMethod interceptor;

		protected ProxyGeneration() {
		}
		
		protected void setObject(BundlingMethod object) {
			this.object = object;
		}


		protected void setInterceptor(InterceptorMethod interceptor) {
			this.interceptor = interceptor;
		}


		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Object pObject=null;
			interceptor.before();
			pObject=method.invoke(object, args);
			interceptor.after();
			return pObject;
		}
		/**
		 * 获取代理对象
		 * @return Object  返回的代理对象
		 */
		protected Object getProxy(){
			return  Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),this);
		}

}
