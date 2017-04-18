package com.Hughesoft.XML;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Test01 {

	public static void main(String[] args) {
		try {
			SAXReader reader =new SAXReader();
			Document d=reader.read(new File("D:/Javatest/test_data/test.xml"));
			System.out.println(d);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
