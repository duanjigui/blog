package com.blog.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyGeneration implements InvocationHandler {
	//��Ҫ�󶨵Ķ����޶�ΪBoldMethod����
		protected BundlingMethod object;
		//��Ҫ��ִ�з����Ķ���
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
		 * ��ȡ�������
		 * @return Object  ���صĴ������
		 */
		protected Object getProxy(){
			return  Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),this);
		}

}
