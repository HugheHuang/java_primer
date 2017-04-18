package com.Hughesoft.network01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		//�������˾��Ǵ�����Ӧ��ServerSocket
		ServerSocket ss = null;
		Socket s=null;
		try {
			ss=new ServerSocket(5858);
			//��Ϊ��������һ�㲻ֹͣ����,������Ҫ��ѭ��
			while(true){
				try{//�˴��ͽ�����һ���ͻ��˵�����
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
