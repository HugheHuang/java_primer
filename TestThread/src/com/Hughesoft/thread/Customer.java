package com.Hughesoft.thread;

public class Customer implements Runnable {
	private String name;
	private Dish d;
	public Customer(String name, Dish d) {
		super();
		this.name = name;
		this.d = d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dish getD() {
		return d;
	}
	public void setD(Dish d) {
		this.d = d;
	}
	
	public void eat(){
		synchronized (d) {
			if(! d.isEmpty()){
				String food=d.getFood();
				System.out.println(name+"’˝‘⁄œÌ ‹"+food);
				d.setEmpty(true);
				d.notify();
				try {
					Thread.sleep(1000);
					d.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				try {
					d.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
	}
	@Override
	public void run() {
		while(true){
			if(d.isEnd()) break;
			eat();
		}
	}
}
