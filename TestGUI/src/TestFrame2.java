import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * ����Frame�ı�̶��ԣ��Ƚϳ��õķ�ʽ�Ǽ̳�Frame��
 * ���ҹ��캯�������±�дһ������������Frame����Ϣ
 */
public class TestFrame2 extends Frame{

	public static void main(String[] args) {
		new TestFrame2();
	}
	
	public TestFrame2(){
		this.setTitle("hello");
		this.setLocation(200,200);
		this.setSize(400, 300);
		this.addWindowListener(new MyWindowListener());
		this.setVisible(true);
		
	}
	
	//������һ������������,ר��ʵ�� WindowListener
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

