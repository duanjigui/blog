package com.blog.gloabal;

public class GlobalProperites {
		/**
		 * 已废弃，已经不使用
		 */
		@Deprecated
		public  static String verfiyCode="1234"; //验证码  [默认的初始值] 测试用
		
		private static  int num=0;   //记录访问的总人数
		
		public synchronized static int NumAddSelf(){
			return ++num;
		}
		public synchronized static int NumSubSelf(){
			return --num;
		}
		public synchronized static int  getNumTotal(){
			return num;
		} 
}
