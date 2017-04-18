package com.Hughesoft.XML;



import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Test03 {

	public static void main(String[] args) {
		try {
			SAXReader reader =new SAXReader();
			//获取xml包中的books.xml
			Document d=reader.read(Test03.class.getClassLoader()
					.getResourceAsStream("XML/books.xml"));
			//获取根元素
			Element re= d.getRootElement();
			System.out.println("root:"+re.getName());
			//并不是null 而是一组空字符串
			System.out.println(re.elementText("book"));
			//获取root的所有子节点
			List<Element> eles=re.elements();
			for(Element ele:eles){
				System.out.println(ele.getName());
				//获取属性为id的值
				System.out.println(ele.attributeValue("id"));
				//获取某个特定子节点的特定属性的文本值
				System.out.println(ele.elementText("title")+ele.elementText("price"));
			
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
