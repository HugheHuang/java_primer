package com.Hughesoft.talk;

import java.sql.Savepoint;

public class Test {

	public static void main(String[] args) {
		Asker asker=new Asker("���");
		Answer ans=new Answer("����", asker);
		Thread ast=new Thread(asker);
		Thread ant =new Thread(ans);
		ant.setDaemon(true);
		ast.start();
		ant.start();
	}

}
