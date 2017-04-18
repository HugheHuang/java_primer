import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestJButton extends JFrame {
	private JButton jb1,jb2;
	public static void main(String[] args) {
		TestJButton f=new TestJButton();
	}
	
	public TestJButton(){
		this.setTitle("hello world");
		this.setSize(500, 500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//创建两个按钮
		jb1=new JButton("hello");
		jb2=new JButton("world");
		//添加按钮
		this.add(jb1);
		this.add(jb2);
		
		this.setVisible(true);
	}

}
