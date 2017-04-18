import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 962094507148302316L;

	public static void main(String[] args) {
		new ChatForm();
	}
	
	private JPanel jp1;
	private JTextArea jta;
	//下拉栏
	private JComboBox jcb;
	private JTextField jtf;
	private JButton jb1;
	//滚动条
	private JScrollPane jsp;
	
	public ChatForm(){
		this.setTitle("聊天");
		this.setSize(600,500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		jta=new JTextArea();
		//创建滚动条时直接将需要滚动的对象通过构造函数创建
		jsp=new JScrollPane(jta);
		//直接添加滚动条就等于添加了滚动条中的组件
		this.add(jsp);
		jp1=new JPanel();
		jcb=new JComboBox(new String[]{"Hughe","Zenas","Xiaobai","Dashan","YellowQIN"});
		jtf=new JTextField(20);
		jb1=new JButton("发送");
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb1);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

}
