package com.Hughesoft.network03;


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
	//用来存储所有的客户端
	private List<ServerThread> clients = null;
	public static void main(String[] args) {
		new Server().startup();
	}
	private void startup(){
		ServerSocket ss=null;
		Socket s=null;
		
		try {
			ss=new ServerSocket(5858);
			clients=new ArrayList<Server.ServerThread>();
				while(true){
					s=ss.accept();
					ServerThread st=new ServerThread(s);
					new Thread(st).start();
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
	
	private class ServerThread implements Runnable{
	
		private boolean flag=true;
		private BufferedReader br;
		private Socket s=null;
		private PrintWriter out;
		private String name;
		
		public ServerThread(Socket s) throws IOException {
			this.s=s;
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out=new PrintWriter(s.getOutputStream(), true);
			String str=br.readLine();
			name =str+"["+s.getInetAddress().getHostAddress()+":"+s.getPort()+"]";
		//	System.out.println(name+"连接上了");
			clients.add(this);
			send(name+"上线了");
		}
		private void send(String msg){
			for(ServerThread st:clients){
				st.out.println(msg);
			}
		}
		private void stop(){
			System.out.println(name+"已经离开");
			clients.remove(this);
			flag=false;
			send(name+"已经下线了");
		}
		private void receive() throws IOException{
			String str=null;
			while((str=br.readLine())!=null){
				if(str.equals("quit")){
					//关闭操作,释放资源
					stop();
					
					out.println("disconnect");
					break;
				}
				System.out.println(name+":"+str);
				send(name+":"+str);
			}
			
		}
		
		public void run() {
			
			try{
				while(true){
					if(!flag) break;
						receive();
				
				}
			}catch (SocketException e){
				stop();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
						if(s!=null)  s.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	}
}
