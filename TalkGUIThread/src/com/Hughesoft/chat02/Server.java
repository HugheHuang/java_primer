package com.Hughesoft.chat02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Server {
	public static final String HOST="127.0.0.1"; 
	public static final int PORT=6868;
	public static final String DISCONNECT_TOKEN="disconnect";
	private List<ServerThread> cs; 
	
	
	public static void main(String[] args) {
		new Server().startup();
	}
	
	private class ServerThread implements Runnable{
		private Socket s;
		private BufferedReader br;
		private PrintWriter out;
		private String name;
		private boolean stop=false;
		
		public ServerThread(Socket s) throws IOException {
			this.s=s;
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out=new PrintWriter(s.getOutputStream(),true);
			this.name=br.readLine();
			//name+="["+s.getInetAddress().getHostAddress()+"]";
			send(name+":"+"连接了");
			cs.add(this);
		}
		
		private void close(){
			stop=true;
			out.println(DISCONNECT_TOKEN);
			cs.remove(this);
			send(name+"断开连接了");
		}
		
		private void send(String str){
			for(ServerThread st:cs){
				st.out.println(str);
			}
		}
		
		@Override
		public void run() {
			try {
				while(true){
					if(stop) break;
					String str = br.readLine();
					if(str.equalsIgnoreCase(DISCONNECT_TOKEN)){
						close();
						break;
					}
					send(name+":"+str);
					
				}
			}catch (SocketException e){
				System.out.println(name+"非正常退出");
				close();
			}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}finally {
				try {
					if(s!=null) s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void startup(){
		ServerSocket ss=null;
		try {
			ss=new ServerSocket(6868);
			cs=new ArrayList<Server.ServerThread>();
			while(true){
				Socket s=ss.accept();
				new Thread(new ServerThread(s)).start();;
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(ss!=null) ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}
