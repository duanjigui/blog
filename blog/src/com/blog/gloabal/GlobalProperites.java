package com.blog.gloabal;

public class GlobalProperites {
		/**
		 * �ѷ������Ѿ���ʹ��
		 */
		@Deprecated
		public  static String verfiyCode="1234"; //��֤��  [Ĭ�ϵĳ�ʼֵ] ������
		
		private static  int num=0;   //��¼���ʵ�������
		
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
