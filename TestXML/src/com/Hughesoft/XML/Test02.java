package com.Hughesoft.XML;

import java.io.File;
import java.net.URL;

public class Test02 {

	public static void main(String[] args) {
		File f=new File("books.xml");
		System.out.println(f.exists());
		/**
		 * 要获取类路径下的文件可以通过
		 * 类.class.getClassLoader().getResource(name)获取
		 */
		URL url=Test02.class.getClassLoader().getResource("books.xml");
		//根据URL获取完整路径
		System.out.println(url.getPath());
		f=new File(url.getPath());
		System.out.println(f.exists());
	}

}
