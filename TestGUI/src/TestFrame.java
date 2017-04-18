import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestFrame {

	public static void main(String[] args) {
		//所有的组件都是放置在Frame中的
		Frame f=new Frame();
		Button btn=new Button("hello");
		f.add(btn);
		//设置标题
		f.setTitle("hello world");
		//设置窗口大小
		f.setSize(500, 500);
		//设置窗口位置
		f.setLocation(100, 100);
		//为frame添加窗口的监听事件,此时,当窗口发生改变时,自动执行流程
		f.addWindowListener(new MyWindowListener());
		//将窗口显示
		f.setVisible(true);
		
		//注意无法关闭窗口
	}

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

