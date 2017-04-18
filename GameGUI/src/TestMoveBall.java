import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMoveBall extends JFrame{
	private MyPanel mp;
	private JButton jb;
	private Thread mt;
	public static void main(String[] args) {
		new TestMoveBall();
	}
	public TestMoveBall(){
		this.setSize(600,500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jb=new JButton("ÒÆ¶¯µÄÐ¡Çò");
		jb.addActionListener(new BtnClickEvent());
		this.add(jb,BorderLayout.NORTH);
		
		mp=new MyPanel(40, 40);
		this.add(mp);
		mt=new Thread(mp);
		
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel implements Runnable{
		int x,y;
		public  MyPanel(int x,int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.red);
			g.fillOval(x, y, 50,50);
		}
		@Override
		public void run() {
			for(int i=0;i<200;i++){
				mp.x+=3;
				mp.repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	
	}
	class BtnClickEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb){
				mt.start();
				
			}
		}
		
   }
}

