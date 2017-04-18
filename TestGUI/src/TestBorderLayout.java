import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestBorderLayout extends JFrame {
	private JButton jb1,jb2,jb3,jb4,jb5;
	public static void main(String[] args) {
		TestBorderLayout f=new TestBorderLayout();
	}
	
	public TestBorderLayout(){
		this.setTitle("hello world");
		this.setSize(500, 500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ø�Frame�Ĳ���ΪBorderLayout,Ĭ�Ͼ���BorderLayout
		//�������ϣ�����ô�ֱ��ˮƽ���,��Ҫ����һ��BorderLayout����
		this.setLayout(new BorderLayout(10,10));
		//����5����ť
		jb1=new JButton("N");
		jb2=new JButton("S");
		jb3=new JButton("W");
		jb4=new JButton("E");
		jb5=new JButton("C");
		//��Ӱ�ť,��λ��
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		this.add(jb3,BorderLayout.WEST);
		this.add(jb4,BorderLayout.EAST);
		this.add(jb5,BorderLayout.CENTER);
		this.setVisible(true);
	}

}
