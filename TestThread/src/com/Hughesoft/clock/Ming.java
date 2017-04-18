package com.Hughesoft.clock;



public class Ming implements Runnable{

	private Clock c;

	public Clock getC() {
		return c;
	}

	public void setC(Clock c) {
		this.c = c;
	}

	public Ming(Clock c) {
		super();
		this.c = c;
	}
	@Override
	public void run() {
		while(true){
			operator();
		}
	}
	public void operator(){
		synchronized (c) {
			if(c.isWakeup()){
				System.out.println("С��˵:֪����");
				c.setWakeup(false);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.notify();
				try {
					c.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
