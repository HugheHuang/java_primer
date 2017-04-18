import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestGraphics extends JFrame {
	private MyPanel mp;
	
	public static void main(String[] args) {
		new TestGraphics();
	}
	
	private class MyPanel extends JPanel{
		public void paint(Graphics g){
			super.paint(g);
			g.setColor(Color.BLACK);
			g.drawRect(10, 10, 200, 200);
			g.setColor(Color.YELLOW);
			g.fillOval(20, 20, 40, 40);
		}
	}
	
	public TestGraphics(){
		this.setSize(500,500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mp=new MyPanel();
		this.add(mp);
		this.setVisible(true);
	}
}
