import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {

	public static void main(String[] args) {
		new LoginForm();
	}
	
	private JPanel jp1,jp2,jp3;
	private JButton jb1,jb2;
	private JLabel jl1,jl2;
	private JTextField jtf;
	private JPasswordField jpf;
	
	public LoginForm(){
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
		jb2=new JButton("取消");
		jp3.add(jb1);
		jp3.add(jb2);
		this.add(jp3);
		
		this.setVisible(true);
	}
}
