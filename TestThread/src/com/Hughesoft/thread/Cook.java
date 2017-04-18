package com.Hughesoft.thread;

import java.util.Random;

public class Cook implements Runnable{
	private String name;
	private String [] foods;
	private Dish d;
	private static Random ran=new Random();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getFoods() {
		return foods;
	}
	public void setFoods(String[] foods) {
		this.foods = foods;
	}
	public Dish getD() {
		return d;
	}
	public void setD(Dish d) {
		this.d = d;
	}
	public Cook(String name, Dish d) {
		super();
		this.name = name;
		this.d = d;
		foods =new String[]{"大米","馒头","果汁","稀饭","披萨","红酒","砒霜"};
	}
	
	public void make(){
		synchronized (d) {
			if(d.isEmpty()){
				int index=ran.nextInt(foods.length);
				String f=foods[index];
				System.out.println(name+"制作了"+f);
				d.setFood(f);
				d.setEmpty(false);
				d.notify();
				try {
					Thread.sleep(1000);
					d.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					d.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			//不能依赖于sleep来控制线程,各种安全问题
/*			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/
		}
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			make();
			//System.out.println(i);
			
		}
		
	}
}
