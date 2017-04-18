package com.Hughesoft.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {

	public static void main(String[] args) {
		DatagramSocket ds=null;
		try {
			//UDP���ն�
			ds=new DatagramSocket(9999);
			//���彫UDP�����ݰ����ܵ�ʲô�ط�
			byte[] buf=new byte[1024];
			//����UDP�����ݽ��հ�
			DatagramPacket dp=new DatagramPacket(buf, buf.length);
			while(true){
				//�������ݰ�
				ds.receive(dp);
				String str=new String(dp.getData(),0,dp.getLength());
				System.out.println(str);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ds==null) ds.close();
		}
	}

}
