import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class TestKeyEvent extends JFrame {

	public static void main(String[] args) {
		new TestKeyEvent();
	}
	public TestKeyEvent(){
		this.setLocation(100,100);
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		this.addKeyListener(new MyKeyEvent());
		
		this.setVisible(true);
	}
	class MyKeyEvent extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			super.keyPressed(e);
			if(e.getKeyCode()==KeyEvent.VK_UP)
			 	System.out.println("up");
			else if(e.getKeyCode()==KeyEvent.VK_DOWN)
				System.out.println("down");
			else if(e.getKeyCode()==KeyEvent.VK_LEFT)
				System.out.println("left");
			else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				System.out.println("right");
		}
	}

}
