import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/*
 * 对于Frame的编程而言，比较常用的方式是继承Frame类
 * 并且构造函数或者新编写一个函数来设置Frame的信息
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
	
	//定义了一个监听器的类,专门实现 WindowListener
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

