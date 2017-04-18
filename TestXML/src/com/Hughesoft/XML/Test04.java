package com.Hughesoft.XML;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.SaslException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test04 {

	public static void main(String[] args) {
		try {
			SAXReader reader=new SAXReader();
			Document d=reader.read(Test04.class.getClassLoader().getResource("XML/Books.xml"));
			Element e=findByTitle(d, "java编程思想");
			System.out.println(e.elementText("price"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static Element findByTitle(Document d,String title){
		Element root =d.getRootElement();
		List<Element> eles=root.elements("book");
		for(Element e:eles){
			String t=e.elementTextTrim("title");
			if(t.equals(title)){
				return e;
			}
		}
		return null;
	}
	private static void tran(){
		try {
			SAXReader reader=new SAXReader();
			Document d=reader.read(Test04.class.getClassLoader().getResource("XML/Books.xml"));
			Element root =d.getRootElement();
			List<Element> eles= root.elements("book");
			List <Book> books=new ArrayList<Book>();
			for(Element e:eles){
				Book b=new Book();
				b.setId(Integer.parseInt(e.attributeValue("id")));
				b.setTitle(e.elementText("title"));
				b.setAuthor(e.elementText("author"));
				b.setPrice(Double.parseDouble(e.elementText("price")));;
				books.add(b);
			}
			for(Book b:books){
				System.out.println(b);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
}
