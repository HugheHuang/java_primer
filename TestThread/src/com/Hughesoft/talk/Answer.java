package com.Hughesoft.talk;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Answer implements Runnable{
	private  String name;
	private Asker asker;
	private String [] answers;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Asker getAsker() {
		return asker;
	}

	public void setAsker(Asker asker) {
		this.asker = asker;
	}
	
	public Answer(String name, Asker asker) {
		super();
		this.name = name;
		this.asker = asker;
		answers=new String[]{"我在睡觉","我在看笔记","中国队总是输","上帝笑了","我在上厕所","下雨了"};
	}

	@Override
	public void run() {
		while(true){
			answer();
		}
	}
	
	public void answer(){
		
		synchronized (asker) {
			try {
				if (asker.isAsk()) {
					String q = asker.getQuestion();
					int index = Asker.ran.nextInt(answers.length);
					String an = answers[index];
					System.out.println(name+":"+an);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					asker.setAsk(false);
					asker.notify();
					asker.wait();
				} else asker.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
