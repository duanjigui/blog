package com.blog.interceptor;
/**
 * <p>��װ�෽����ר�����ɴ���,�Եײ�����ʵ��ϸ�ڽ��з�װ</p>
 * <p>��ȡ������ʱ������ʹ�ô˷���</p>
 * @author duanjigui
 *@data 2016/5/14
 *@version 1.0
 */
public class BundlingProxy extends ProxyGeneration {
	//�����������������ֵ
	public BundlingProxy(BundlingMethod object, InterceptorMethod interceptor) {
		super.setObject(object);
		super.setInterceptor(interceptor);
	}
	public Object getObject() {
		return super.getProxy();
	}
	//�ṩ�����������ð󶨷���
	public void setObject(BundlingMethod object) {
		super.setObject(object);
	}

	//�ṩ�����������ð󶨷���֮ǰ��֮��ʵ�ֵķ���
	public void setInterceptor(InterceptorMethod interceptor) {
		super.setInterceptor(interceptor);
	}

}
