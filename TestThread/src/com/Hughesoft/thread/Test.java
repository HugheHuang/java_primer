package com.Hughesoft.thread;

public class Test {

	public static void main(String[] args) {
		Dish d=new Dish();
		Cook co=new Cook("������", d);
		Customer cu=new Customer("��С��", d);
		Thread cot=new Thread(co);
		Thread cut=new Thread(cu);
		//cutΪ��̨�߳�,ֻҪ�����߳̽���,����߳��Զ�����
		cut.setDaemon(true);
		cot.start();
		cut.start();
	}

}
