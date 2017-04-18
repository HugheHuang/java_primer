package com.Hughesoft.network02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		Socket s=null;
		//专门用来处理标准输入流的对象
		BufferedReader sbr=null;
		try {
			s=new Socket("127.0.0.1", 5858);
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);
			//专门用来读取标准输入
			sbr=new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br=new BufferedReader( new InputStreamReader(s.getInputStream()));
			String str =null;
			while((str=sbr.readLine())!=null){
			//	if (str.equals("quit")) break;
				out.println(str);
				String rs=br.readLine();
				System.out.println("Receive:"+rs);
				if(rs.equals("disconnect")){
					break;
				}
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
}
