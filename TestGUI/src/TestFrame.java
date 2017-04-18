import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestFrame {

	public static void main(String[] args) {
		//���е�������Ƿ�����Frame�е�
		Frame f=new Frame();
		Button btn=new Button("hello");
		f.add(btn);
		//���ñ���
		f.setTitle("hello world");
		//���ô��ڴ�С
		f.setSize(500, 500);
		//���ô���λ��
		f.setLocation(100, 100);
		//Ϊframe��Ӵ��ڵļ����¼�,��ʱ,�����ڷ����ı�ʱ,�Զ�ִ������
		f.addWindowListener(new MyWindowListener());
		//��������ʾ
		f.setVisible(true);
		
		//ע���޷��رմ���
	}

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

