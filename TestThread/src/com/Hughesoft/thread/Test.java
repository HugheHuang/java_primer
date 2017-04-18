package com.Hughesoft.thread;

public class Test {

	public static void main(String[] args) {
		Dish d=new Dish();
		Cook co=new Cook("刘大胖", d);
		Customer cu=new Customer("李小胖", d);
		Thread cot=new Thread(co);
		Thread cut=new Thread(cu);
		//cut为后台线程,只要所有线程结束,这个线程自动结束
		cut.setDaemon(true);
		cot.start();
		cut.start();
	}

}
