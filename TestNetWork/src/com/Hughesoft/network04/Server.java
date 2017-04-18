package com.Hughesoft.network04;

import java.awt.SecondaryLoop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<ServerThread> cs=null;
	public static void main(String[] args) {
		new Server().startup();
	}
	
	public void startup(){
		ServerSocket ss=null;
		
		try {
			ss=new ServerSocket(6666);
			cs=new ArrayList<Server.ServerThread>();
			while(true){
				Socket s=ss.accept();
				new Thread(new ServerThread(s)).start(); ;
				new Thread(new ServerWriteThread()).start(); ;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//专门用来服务器端写数据
	private class ServerWriteThread implements Runnable{
		public void run() {
			BufferedReader br=null;
			try {
				br=new BufferedReader(new InputStreamReader(System.in));
				String str=null;
				while((str=br.readLine())!=null){
					send(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	finally {
				 try {
					if(br!=null) br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	private void send (String msg){
		for(ServerThread st:cs){
			st.out.println(msg);
		}
	}
	private class ServerThread implements Runnable{
		private Socket s;
		private BufferedReader br;
		private PrintWriter out=null;
		private String name;
		private boolean flag=true;
		
		public ServerThread(Socket s) throws IOException {
			this.s=s;
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out=new PrintWriter(s.getOutputStream(),true);
			name=s.getLocalAddress().getHostName()+":"+s.getPort();
			System.out.println(name+"上线了");
			cs.add(this);
		}
		
		
		private void stop(){
			System.out.println(name+"下线了");
			cs.remove(this);
			flag=false;
		}
		public void run() {
			try {
				while(true){
					if(!flag) break;
					
					String str=br.readLine();
					System.out.println(str);
				}
			} catch (SocketException e){
				stop();
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
	}

}
