import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class TestFrameEvent2 extends JFrame {
	
	public TestFrameEvent2(){
		
		this.addWindowListener(new MyWindowListener1());
		this.setTitle("hello");
		this.setLocation(200,200);
		this.setSize(400, 300);
		this.setVisible(true);
	}
	//�����������ʵû���κα��ⲿ���ʵĿ���,����ֱ���ڲ���
	//���ֱ��ʵ�� WindowListener�ᵼ��ʵ���������з���,���еķ���û����
	//��ʱjava���ṩ��һ��������(Adapter)�ķ��������
	//ÿһ���������ӿڶ���������������
	//�����Խӿڵ�ÿһ������ʵ�п�ʵ��
	class MyWindowListener1 extends WindowAdapter{
			public void windowClosing(WindowEvent e) {
				System.out.println("closing");
				System.exit(0);
			}

		}


}
