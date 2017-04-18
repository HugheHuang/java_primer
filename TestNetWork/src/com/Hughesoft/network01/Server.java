package com.Hughesoft.network01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		//服务器端就是创建相应的ServerSocket
		ServerSocket ss = null;
		Socket s=null;
		try {
			ss=new ServerSocket(5858);
			//因为服务器端一般不停止工作,所以需要死循环
			while(true){
				try{//此处就接受了一个客户端的需求
					s=ss.accept();
					String name =s.getInetAddress().getHostAddress()+":"+s.getPort();
//					System.out.println("a client connect"+"   "+s.getPort()+"  "+s.getInetAddress());
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String str=br.readLine();
					System.out.println(name+"--"+str);
					PrintWriter out=new PrintWriter(s.getOutputStream(),true);
					out.println("Receive:"+str);
				} finally{
					if(s!=null) s.close();
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ss!=null)
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
