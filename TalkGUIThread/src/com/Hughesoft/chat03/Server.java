package com.Hughesoft.chat03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Set;

import com.sun.glass.ui.Pixels.Format;
import com.sun.javafx.collections.MappingChange.Map;

public class Server {
	public static final String HOST="127.0.0.1"; 
	public static final int PORT=6868;
	public static final String DISCONNECT_TOKEN="disconnect";
	public static final String TRAN_USER_FLAG="connect:";
	public static final String CHAT_FLAG_START="to:";
	public static final String CHAT_FLAG_END=":end";
	private HashMap<String, ServerThread> cs; 
	
	
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
			cs.put(name,this);
			send(name+":"+"连接了");
			sendUser();
			
		}
		
		private void sendUser(){
			String us=TRAN_USER_FLAG;
			Set<String> keys=cs.keySet();
			for(String u:keys){
				us+=u+",";
			}
			send(us);
		}
		
		private void close(){
			stop=true;
			out.println(DISCONNECT_TOKEN);
			cs.remove(name);
			send(name+"退出了聊天室");
			sendUser();
		}
		
		private void send(String str){
			Set<String> keys=cs.keySet();
			for(String key:keys){
				cs.get(key).out.println(str);
			}
		}
		
		private String getUserMsg(String msg){
			String str=msg.substring(CHAT_FLAG_START.length(),msg.indexOf(CHAT_FLAG_END));
			return str;
		}
		
		private String formatMsg(String msg){
			String str=msg.substring(msg.indexOf(CHAT_FLAG_END)+CHAT_FLAG_END.length());
			return str;
		}
		
		private void sendPrivateUsers(String us,String msg){
			String [] uus=us.split(",");
			for(String u:uus){
				cs.get(u).out.println(name+":"+msg+"------------[来自私聊信息]");;
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
					String us=getUserMsg(str);
					String msg=formatMsg(str);
					if(us.equals("all")){
						send(name+":"+msg+"------------[来自群聊信息]");
					} else {
						sendPrivateUsers(us,msg);
					}
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
			cs= new HashMap<String,ServerThread>();
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
