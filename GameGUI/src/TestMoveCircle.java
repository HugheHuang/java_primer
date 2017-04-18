import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMoveCircle extends JFrame {
	
	private MyPanel mp;
	
	public static void main(String[] args) {
		new TestMoveCircle();
	}
	public TestMoveCircle(){
		this.setLocation(100, 100);
		this.setTitle("移动的小球");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mp=new MyPanel(50,50);
		
		this.addKeyListener(new MyKeyEvent());
		this.add(mp);
		this.setVisible(true);
	}
	private class MyKeyEvent extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			if(e.getKeyCode()==KeyEvent.VK_UP){
				mp.y-=5;
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN){
				mp.y+=5;
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT){
				mp.x-=5;
			}
			else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				mp.x+=5;
			}
			//让面板刷新
			mp.repaint();
			
		}
	}
	private class MyPanel extends JPanel{
		
		private int x;
		private int y;
		
		public MyPanel(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.red);
			g.fillOval(x,y, 20, 20);
		}
	}
}
