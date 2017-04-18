package com.Hughesoft.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Sender {

	public static void main(String[] args) {
		DatagramSocket ds=null;
		try {
			//定义一个UDP的Socket来发送数据
			ds=new DatagramSocket();
			//假设发送的是一个字符串
			String hello="hello world";
			//定义一个UDP的数据发送包来发送数据,InetSocketAddress表示接收地址
			DatagramPacket dp=new DatagramPacket(hello.getBytes(), 
					hello.getBytes().length,new InetSocketAddress("127.0.0.1",9999));
			for(int i=0;i<10;i++){
				ds.send(dp);
				Thread.sleep(1000);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ds!=null) ds.close();
		}
		
	}

}
