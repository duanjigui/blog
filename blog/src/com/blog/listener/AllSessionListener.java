package com.blog.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.blog.gloabal.GlobalProperites;
/**
 * <p>记录网站浏览用户的总数</p>
 * @author duanjigui
 *@since 1.0
 *@time 2016/5/30
 */
public class AllSessionListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
			GlobalProperites.NumAddSelf();
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		GlobalProperites.NumSubSelf();
	}

}
