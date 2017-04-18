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
			//����һ��UDP��Socket����������
			ds=new DatagramSocket();
			//���跢�͵���һ���ַ���
			String hello="hello world";
			//����һ��UDP�����ݷ��Ͱ�����������,InetSocketAddress��ʾ���յ�ַ
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
