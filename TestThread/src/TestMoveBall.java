import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketOption;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMoveBall extends JFrame{
	private MyPanel mp;
	private JButton jb1,jb2;
	private Thread mt;
	public static void main(String[] args) {
		new TestMoveBall();
	}
	public TestMoveBall(){
		this.setSize(600,500);
		this.setLocation(200,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jb1=new JButton("移动的小球");
		jb1.addActionListener(new BtnClickEvent());
		this.add(jb1,BorderLayout.NORTH);
		
		jb2=new JButton("停止运动");
		jb2.addActionListener(new BtnClickEvent());
		this.add(jb2,BorderLayout.SOUTH);
		
		mp=new MyPanel(40, 40);
		this.add(mp);
		mt=new Thread(mp);
		
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel implements Runnable{
		int x,y;
		private boolean flag =true ;
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
				if(!flag) break;
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
		public void stop(){
			flag=false;
		}
	
	}
	class BtnClickEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jb1){
				mt.start();
				
			}else if(e.getSource()==jb2){
				mp.stop();
			}
		}
		
   }
}

