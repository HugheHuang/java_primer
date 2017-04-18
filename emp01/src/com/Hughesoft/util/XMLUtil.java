package com.Hughesoft.util;

import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {
	private static Document userDocument;
	
	public static Document getUserDocument(){
		//如果存在Document直接返回
		if(userDocument!=null) return userDocument;
		try {
			//如果不存在就创建对象
			SAXReader reader =new SAXReader();
			userDocument=reader.read(XMLUtil.class.getClassLoader().getResource("xml/users.xml"));
			return userDocument;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void write2XML(Document d,String name){
		XMLWriter out=null;
		try {
			String path=XMLUtil.class.getClassLoader().getResource("xml/"+name+".xml").getPath();
			path=path.replace("bin", "src");
			out=new XMLWriter(new FileWriter(path),OutputFormat.createPrettyPrint());
			out.write(d);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(out!=null) out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
