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
	//由于这个类其实没有任何被外部访问的可能,所以直接内部类
	//如果直接实现 WindowListener会导致实现里面所有方法,但有的方法没有用
	//此时java就提供了一种适配器(Adapter)的方案来解决
	//每一个监听器接口都存在适配器的类
	//这个类对接口的每一个方法实行空实现
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
