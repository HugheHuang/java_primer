package com.Hughesoft.thread;

public class Dish {
	private String food;
	private boolean empty;
	private boolean end;
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public Dish() {
		empty=true;
		end=false;
	}
	
	
}

