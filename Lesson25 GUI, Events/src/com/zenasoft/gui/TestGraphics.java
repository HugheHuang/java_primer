package com.zenasoft.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGraphics extends JFrame {	// TestGraphics 是一面墙
	private MyPanel mp;
	
	/*
	 * 写一个类继承 JPanel，
	 * 覆盖其中的 paint 方法，
	 * 将这个类创建实例添加至主墙上。
	 */
	private class MyPanel extends JPanel {	// MyPanel 是一块板
		@Override
		public void paint(Graphics g) {	// Graphics g 是一支画笔 
			super.paint(g);
			g.setColor(Color.BLACK);
			g.drawRect(10, 10, 100, 100);
			g.setColor(Color.YELLOW);
			g.fill3DRect(200, 10, 100, 100, true);
			g.setColor(Color.green);
			g.fillOval(10, 200, 300, 200);
		}
	}
	
	public TestGraphics() {	// 定义墙
		this.setSize(500, 500);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 将板加到墙上
		mp = new MyPanel();
		this.add(mp);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestGraphics();
	}

}
