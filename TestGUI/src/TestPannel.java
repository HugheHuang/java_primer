import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.print.attribute.TextSyntax;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPannel extends JFrame {

	public static void main(String[] args) {
		TestPannel f=new TestPannel();
	}
	
	private JPanel jp1,jp2;
	private JButton jb1,jb2,jb3,jb4,jb5;
	
	public TestPannel(){
		this.setTitle("hello world");
		this.setSize(500, 500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//JPanel的默认布局是流式布局 FlowLayout
		//Jpanel相当于一个容器
		jp1=new JPanel();
		jp2=new JPanel();
		//创建5个按钮
		jb1=new JButton("A");
		jb2=new JButton("B");
		jb3=new JButton("C");
		jb4=new JButton("D");
		jb5=new JButton("E");
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		this.add(jb5);
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
