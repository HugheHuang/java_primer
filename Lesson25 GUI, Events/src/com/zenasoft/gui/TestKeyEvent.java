package com.zenasoft.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestKeyEvent extends JFrame {
	private JTextField jtfInput;
	private JLabel	jlResult;

	public static void main(String[] args) {
		new TestKeyEvent();
	}
	
	public TestKeyEvent() {
		this.setLocation(100, 100);
		this.setSize(800, 600);
		this.setTitle("Test Key Event");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jtfInput = new JTextField();
		this.add(jtfInput);
		jtfInput.addKeyListener(new MyKeyEvent());
		
		this.setVisible(true);
	}
	
	class MyKeyEvent extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			System.out.println(e.getKeyCode() + ": " + e.getKeyText(e.getKeyCode()));
		}
	}
}
