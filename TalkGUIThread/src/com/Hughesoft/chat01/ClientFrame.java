package com.Hughesoft.chat01;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClientFrame extends JFrame {

	private JTextArea jta;
	private JTextField jtf;
	private JPanel jp;
	private JButton jbtn;
	private JList list;
	private DefaultListModel model;
	private JScrollPane jsp1,jsp2;
	private String name;
	public ClientFrame(String name) {
		this.setSize(800, 600);
		this.setLocation(100, 100);
		this.name=name;
		this.setTitle("网络聊天|当前用户是["+this.name+"]");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jta=new JTextArea();
		jsp1=new JScrollPane(jta);
		jtf=new JTextField(35);
		jbtn=new JButton("发送");
		jbtn.addActionListener(new BtnClick());
		model=new DefaultListModel();
		list=new JList<>(model);
		//设置了宽度之后,如果宽度不够会使用...代替多余部分
		//list.setFixedCellWidth(100);
		jsp2=new JScrollPane(list);
		jp=new JPanel();
		this.add(jsp1);
		jp.add(jtf); jp.add(jbtn);
		this.add(jp,BorderLayout.SOUTH);
		this.add(jsp2,BorderLayout.WEST);
		jtf.addKeyListener(new KeyClick());
		
		this.setVisible(true);
		
	}
	private class KeyClick extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				send();
		}
	}
	
	private void send(){
		
			String word=jtf.getText();
			if(word==""||word.trim().equals("")){
				return;
			}
			model.addElement(word);
			jta.setText(jta.getText()+name+":"+word+"\n");
			jtf.setText("");
		
	}
	private class BtnClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbtn){
				send();
				Object[] vals=list.getSelectedValues();
				for(Object v:vals){
					System.out.println(v);
				}
			}
		}
	}
		
	}
