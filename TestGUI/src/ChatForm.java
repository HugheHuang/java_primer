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
	//������
	private JComboBox jcb;
	private JTextField jtf;
	private JButton jb1;
	//������
	private JScrollPane jsp;
	
	public ChatForm(){
		this.setTitle("����");
		this.setSize(600,500);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		jta=new JTextArea();
		//����������ʱֱ�ӽ���Ҫ�����Ķ���ͨ�����캯������
		jsp=new JScrollPane(jta);
		//ֱ����ӹ������͵�������˹������е����
		this.add(jsp);
		jp1=new JPanel();
		jcb=new JComboBox(new String[]{"Hughe","Zenas","Xiaobai","Dashan","YellowQIN"});
		jtf=new JTextField(20);
		jb1=new JButton("����");
		jp1.add(jcb);
		jp1.add(jtf);
		jp1.add(jb1);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

}
