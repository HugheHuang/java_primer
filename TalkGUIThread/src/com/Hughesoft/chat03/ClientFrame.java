package com.Hughesoft.chat03;

import java.awt.BorderLayout;
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
		this.setTitle("网络聊天|HugheSoftware|当前用户是["+this.name+"]");
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				out.println(Server.DISCONNECT_TOKEN);
			}
		});
		
		jta=new JTextArea();
		jsp1=new JScrollPane(jta);
		jtf=new JTextField(35);
		jbtn=new JButton("发送");
		jbtn.addActionListener(new BtnClick());
		model=new DefaultListModel();
		list=new JList<>(model);
		//设置了宽度之后,如果宽度不够会使用...代替多余部分
		list.setFixedCellWidth(100);
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
			if(word==null||word.trim().equals("")){
				return;
			}
			Object[] vals =list.getSelectedValues();
			boolean isAll =false;
			String us=Server.CHAT_FLAG_START;
			if(vals.length<=0){
				isAll=true;
			}
			for(Object v:vals){
				if(v.toString().equals("所有人")){
					isAll=true;
					break;
				} else{
					us+=v.toString()+",";
				}
			}
			if(isAll){
				out.println(us+"all"+Server.CHAT_FLAG_END+word);
			} else{
				out.println(us+Server.CHAT_FLAG_END+word);
			}
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
		if(str.startsWith(Server.TRAN_USER_FLAG)){
			handleList(str);
			return;
		}
		jta.setText(jta.getText()+str+"\n");
	}
	
	private void handleList(String str){
		String users=str.substring(Server.TRAN_USER_FLAG.length());
		String [] us=users.split(",");
		model.removeAllElements();
		model.addElement("所有人");
		for(String u:us){
			model.addElement(u);
		}
		
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
