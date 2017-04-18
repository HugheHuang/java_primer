package com.Hughesoft.viewer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class UserPanel extends JPanel {
	private JPanel jp1,jp2;
	private JLabel jl1;
	private JTable jt;
	private JScrollPane jsp;
	private JButton jb1,jb2,jb3;
	
	public UserPanel() {
		this.setLayout(new BorderLayout());
		jp1=new JPanel();
		jp2=new JPanel();
		jl1=new JLabel("用户管理界面");
		jb1=new JButton("添加用户");
		jb2=new JButton("删除用户");
		jb3=new JButton("修改用户");
		jp1.add(jl1);
		jp2.add(jb1);jp2.add(jb2);jp2.add(jb3);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);
		
		
	}
}
