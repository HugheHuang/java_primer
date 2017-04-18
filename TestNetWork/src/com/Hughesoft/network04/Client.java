package com.Hughesoft.network04;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Client {
	private PrintWriter out;
	public static void main(String[] args) {
		new Client().startup();
	}
	
	public void startup(){
		Socket s=null;
		try {
			 s=new Socket("127.0.0.1",6666);
			 out=new PrintWriter(s.getOutputStream(),true);
			 BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
					while(true){
				String str=br.readLine();
			//	System.out.println(str);
				handle(str);
				out.println("receive:"+str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(s!=null) s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private void handle(String str){
		String con=str.substring(0,2);
		String msg=str.substring(2);
		if(con.equalsIgnoreCase("1-")){
			//遍历文件夹
			getFile(msg);
			
		} else if(con.equalsIgnoreCase("2-")){
			adv(msg);
		}
		System.out.println(con+","+msg);
	}
	private void adv(String msg) {
		new MyFrame(msg);
	}
	private class MyFrame extends JFrame{
		public MyFrame(String str) {
			this.setLocation(100,100);
			this.setSize(300, 200);
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setTitle("注意小广告来了");
			JLabel jl=new JLabel("<html>"+str+"</html>");
			this.add(jl);
			
			this.setVisible(true);
			
		}
	}
	private void getFile(String path){
		File f=new File(path);
		if(f.exists()){
			String [] fs=f.list();
			StringBuilder sb=new StringBuilder();
			for(String fn:fs){
				sb.append(fn).append("[##]");
			}
			out.println(sb.toString());
		} else{
			out.println("文件夹不存在");
		}
	}
}
