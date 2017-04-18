package com.Hughesoft.network02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket ss=null;
		Socket s=null;
		
		try {
			ss=new ServerSocket(5858);
			
				while(true){
					try {
						s=ss.accept();
						String name=s.getInetAddress().getHostAddress()+":"+s.getPort();
						System.out.println(name+"连接上了");
						BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
						PrintWriter out=new PrintWriter(s.getOutputStream(),true);
						String str=null;
						while((str=br.readLine())!=null){
							if(str.equals("quit")){
								//关闭操作,释放资源
								out.println("disconnect");
								break;
							}
							System.out.println(name+":"+str);
							out.println(str);
						}
						System.out.println(name+"已经离开");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if(s!=null) s.close();
					}
			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ss!=null) ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
