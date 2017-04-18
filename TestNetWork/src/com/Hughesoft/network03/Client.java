package com.Hughesoft.network03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket s;
	private BufferedReader br;
	private PrintWriter out;
	private boolean flag=true;
	public static void main(String[] args) {
		new Client().startup();
	}
	
	public void startup(){
		
		//专门用来处理标准输入流的对象
		BufferedReader sbr=null;
		try {
			s=new Socket("127.0.0.1", 5858);
			out=new PrintWriter(s.getOutputStream(),true);
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out.println("Hughe");
			//专门用来读取标准输入
			sbr=new BufferedReader(new InputStreamReader(System.in));
			new Thread (new ClientThread()).start();
			String str =null;
			while((flag)&&(str=sbr.readLine())!=null){
			//	if (str.equals("quit")) break;
				out.println(str);
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if(sbr!=null)
				try {
					sbr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	private void receive() {
		try {
			String rs=br.readLine();
			if(rs.equals("disconnect")){
				flag=false;
				System.out.println("点击回车退出");
			}	
			System.out.println(rs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private class ClientThread implements Runnable{
		public void run() {
			while(true){
				if(!flag) break;
				receive();
			}
		}
	}
}
