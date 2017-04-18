import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFormEvent2 extends JFrame {

	public static void main(String[] args) {
		new LoginFormEvent2();
	}
	
	private JPanel jp1,jp2,jp3;
	private JButton jb1,jb2;
	private JLabel jl1,jl2;
	private JTextField jtf;
	private JPasswordField jpf;
	
	public LoginFormEvent2(){
		this.setTitle("用户登录");
		this.setSize(300, 150);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//是否重新定义尺寸
		this.setResizable(false);
		
		this.setLayout(new GridLayout(3, 1));
		jp1=new JPanel();
		jl1=new JLabel("用户名:");
		jtf=new JTextField(20);
		jp1.add(jl1);jp1.add(jtf);
		this.add(jp1);
		
		jp2=new JPanel();
		jl2=new JLabel("密    码:");
		jpf=new JPasswordField(20);
		jp2.add(jl2);
		jp2.add(jpf);
		this.add(jp2);
		
		jp3=new JPanel();
		jb1=new JButton("登录");
		jb1.addActionListener(new MyBtn1Listener());
		jb2=new JButton("取消");
		jb2.addActionListener(new MyBtn1Listener());
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp3);
		
		this.setVisible(true);
	}
	
	class MyBtn1Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//e.getSource()可以获取哪个监听对象触发事件
			//System.out.println(e);
			if(e.getSource()==jb1){
				System.out.println("login");
				System.out.println(jtf.getText());
				//System.out.println(jpf.getText());
				System.out.println(new String(jpf.getPassword()));
			} else if (e.getSource()==jb2){
				System.out.println("cancel");
				jtf.setText("");
				jpf.setText("");
			}
		}
		
	}
	

}
