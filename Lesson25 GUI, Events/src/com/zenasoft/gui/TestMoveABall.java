package com.zenasoft.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMoveABall extends JFrame {
	private MyPanel jp;

	public static void main(String[] args) {
		new TestMoveABall();
	}

	public TestMoveABall() {
		this.setLocation(100, 100);
		this.setSize(1024, 768);
		this.setTitle("Move The Ball");
		
		jp = new MyPanel(100, 100);
		this.add(jp);
		this.addKeyListener(new MyKeyEvent());
		
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private static final long serialVersionUID = -5189422300380270295L;
		
		private int x;
		private int y;
		private int r;
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getR() {
			return r;
		}
		
		public MyPanel(int x, int y) {
			this.x = x;
			this.y = y;
			r = 50;
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.green);
			g.fillOval(x, y, r*2, r*2);
		}
	}
	
	class MyKeyEvent extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(jp.getX() > 0) {
					jp.setX(jp.getX() - 5);
				} else {
					System.out.println("小球达到了左边界。");
				}
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				if(jp.getY() > 0) {
					jp.setY(jp.getY() - 5);
				} else {
					System.out.println("小球达到了上边界。");
				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				jp.setX(jp.getX() + 5);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				jp.setY(jp.getY() + 5);
			}
			jp.repaint();
		}
	}
}
