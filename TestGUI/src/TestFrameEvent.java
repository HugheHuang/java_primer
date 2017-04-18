import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class TestFrameEvent extends JFrame {
	
	public TestFrameEvent(){
		
		this.addWindowListener(new MyWindowListener());
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
	class MyWindowListener implements WindowListener{

			public void windowOpened(WindowEvent e) {
				System.out.println("open");
			}

			public void windowClosing(WindowEvent e) {
				System.out.println("closing");
				System.exit(0);
			}

			public void windowClosed(WindowEvent e) {
				System.out.println("close");
			}

			public void windowIconified(WindowEvent e) {
				System.out.println("windowIconified");
			}

			public void windowDeiconified(WindowEvent e) {
				System.out.println("windowDeiconified");
			}

			public void windowActivated(WindowEvent e) {
				System.out.println("act");
			}

			public void windowDeactivated(WindowEvent e) {
				System.out.println("windowDeactivated");
			}
			
		}


}
