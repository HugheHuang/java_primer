package com.Hughesoft.talk;

import java.util.Random;

public class Asker implements Runnable {
	private  String name;
	private String [] questions;
	private boolean isAsk;
	private String question;
	public static Random ran=new Random();
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	public boolean isAsk() {
		return isAsk;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public static Random getRan() {
		return ran;
	}

	public static void setRan(Random ran) {
		Asker.ran = ran;
	}

	public void setAsk(boolean isAsk) {
		this.isAsk = isAsk;
	}
	
	public Asker(String name) {
		super();
		this.name = name;
		questions =new String[]{"天气好吗","你学习了吗","还有吗","我在和谁说话","吃了吗","你爱不爱我"};
		isAsk=false;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			ask();
		}
	}
	public void ask(){
		synchronized (this) {
			try {
				if(!isAsk){
					int index=ran.nextInt(questions.length);
					question=questions[index];
					System.out.println(name+":"+question);
					Thread.sleep(2000);
					isAsk=true;
					this.notify();
					this.wait();
				} else this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
