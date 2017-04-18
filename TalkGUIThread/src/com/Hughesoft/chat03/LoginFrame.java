package com.Hughesoft.chat03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class LoginFrame extends JFrame {
	public static void main(String[] args) {
		new LoginFrame();
	}
	private JLabel jl;
	private JButton jbtn;
	private JTextField jtf;
	private void close(){
		this.setVisible(false);
	}
	public LoginFrame(){
		this.setLocation(100, 100);
		this.setSize(400,100);
		this.setTitle("用户连接");
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jl=new JLabel("输入用户名");
		jtf=new JTextField(20);
		jbtn =new JButton("连接");
		jtf.addKeyListener(new KeyClick());
		jbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		this.add(jl);
		this.add(jtf);
		this.add(jbtn);
		
		this.setVisible(true);
		
	}
	public void login(){
		String name=jtf.getText();
		if(name==null||name.trim().equals("")){
//			String str=JOptionPane.showInputDialog("请输入名称");
//			jtf.setText(str);
			JOptionPane.showMessageDialog(null, "你必须输入用户名");
			return;
		}
		new ClientFrame(name);
		close();
	}
	private class KeyClick extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				login();
			}
		}
				
	}
}
