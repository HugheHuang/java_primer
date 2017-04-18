package com.Hughesoft.clock;

public class Clock implements Runnable {
	private boolean wakeup;

	public boolean isWakeup() {
		return wakeup;
	}

	public void setWakeup(boolean wakeup) {
		this.wakeup = wakeup;
	}

	public Clock() {
		wakeup=false;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++)
			wake();
		
	}
	
	public void wake(){
		synchronized (this) {
			if(!wakeup){
				System.out.println("起床了!");
				System.out.println("起床了!");
				System.out.println("起床了!");
				wakeup=true;
				this.notify();
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
}
