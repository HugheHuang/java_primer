package com.Hughesoft.chat02;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import com.sun.xml.internal.ws.Closeable;

@SuppressWarnings("serial")
public class ClientFrame extends JFrame {

	private JTextArea jta;
	private JTextField jtf;
	private JPanel jp;
	private JButton jbtn;
	private JList list;
	private DefaultListModel model;
	private JScrollPane jsp1,jsp2;
	private String name;
	private Socket s;
	private BufferedReader br;
	private PrintWriter out;
	private boolean stop=false;
	
	public ClientFrame(String name) {
		this.setSize(800, 600);
		this.setLocation(100, 100);
		this.name=name;
		this.setTitle("��������|��ǰ�û���["+this.name+"]");
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				out.println(Server.DISCONNECT_TOKEN);
			}
		});
		
		jta=new JTextArea();
		jsp1=new JScrollPane(jta);
		jtf=new JTextField(35);
		jbtn=new JButton("����");
		jbtn.addActionListener(new BtnClick());
		model=new DefaultListModel();
		list=new JList<>(model);
		//�����˿��֮��,�����Ȳ�����ʹ��...������ಿ��
		//list.setFixedCellWidth(100);
		jsp2=new JScrollPane(list);
		jp=new JPanel();
		this.add(jsp1);
		jp.add(jtf); jp.add(jbtn);
		this.add(jp,BorderLayout.SOUTH);
		this.add(jsp2,BorderLayout.WEST);
		jtf.addKeyListener(new KeyClick());
		
		connect();
		
		this.setVisible(true);
		
	}
	private void connect(){
		try {
			s=new Socket(Server.HOST,Server.PORT );
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out=new PrintWriter(s.getOutputStream(),true);
			out.println(name);
			new Thread(new ReceiveThread()).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private class KeyClick extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER)
				send();
		}
	}
	
	private void send(){
		
			String word=jtf.getText();
			if(word==""||word.trim().equals("")){
				return;
			}
			out.println(word);
			jtf.setText("");
		
	}
	private class BtnClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbtn){
				send();
			}
		}
	}
	private void close(){
		stop=true;
	}
	
	private void receive() throws IOException{
		String str=br.readLine();
		if(str.equals(Server.DISCONNECT_TOKEN)){
			close();
		}
		jta.setText(jta.getText()+str+"\n");
	}
	private class ReceiveThread implements Runnable{
		@Override
		public void run() {
			try {
				while(true){
					if(stop) {
						break;
					}
					receive();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					if(s!=null) s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
	}	
}
