import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
/*
 * JFrame�Ĳ�����Frame�Ĳ�������һ������������ǻ���Swing�������
 */
public class TestJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		new TestJFrame();
	}
	public TestJFrame(){
		this.setTitle("hello");
		this.setSize(500,400);
		this.setLocation(100,100);
		this.setVisible(true);
		this.setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

