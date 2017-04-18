import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFlowrLayout extends JFrame {
	private JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		TestFlowrLayout f=new TestFlowrLayout();
	}
	
	public TestFlowrLayout(){
		this.setTitle("hello world");
		this.setSize(500, 500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//流式布局
		//FlowLayout(FlowLayout.LEFT,20,30)左对齐,水平间隔20,垂直间隔30
		this.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
		//创建5个按钮
		jb1=new JButton("A");
		jb2=new JButton("B");
		jb3=new JButton("C");
		jb4=new JButton("D");
		jb5=new JButton("E");
		//添加按钮,有位置
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.setVisible(true);
	}

}
