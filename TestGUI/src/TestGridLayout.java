import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGridLayout extends JFrame {
	private JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		TestGridLayout f=new TestGridLayout();
	}
	
	public TestGridLayout(){
		this.setTitle("hello world");
		this.setSize(500, 500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//��񲼾�(���������)  new GridLayout(��,��,ˮƽ���,��ֱ���)
		this.setLayout(new GridLayout(2,3,20,30));
		//����5����ť
		jb1=new JButton("A");
		jb2=new JButton("B");
		jb3=new JButton("C");
		jb4=new JButton("D");
		jb5=new JButton("E");
		//��Ӱ�ť,��λ��
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.setVisible(true);
	}

}
