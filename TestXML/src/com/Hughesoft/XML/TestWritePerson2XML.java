package com.Hughesoft.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class TestWritePerson2XML {

	public static void main(String[] args) {
		XMLWriter out =null;
		try {
			Document d=DocumentHelper.createDocument();
			Element root=d.addElement("persons");
			List<Person>  ps=new ArrayList<Person>();
			ps.add(new Person("张三", "男", "123123", 22));
			ps.add(new Person("李四", "男", "123456", 12));
			ps.add(new Person("王五", "男", "123789", 27));
			ps.add(new Person("马六", "男", "123124", 25));
			root=writeList2XML(root, ps);
			out=new XMLWriter(new FileWriter(TestWritePerson2XML.class.getClassLoader().getResource("XML/persons.xml").getPath().replace("bin", "src")),OutputFormat.createPrettyPrint());
			out.write(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(out!=null) out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	private static Element writeList2XML(Element root,List<Person> persons){
		for(Person p:persons){
			Element ep=root.addElement("person");
			ep.addAttribute("age", p.getAge()+"");
			ep.addElement("name").setText(p.getName());
			ep.addElement("sex").setText(p.getSex());
			ep.addElement("idcard").setText(p.getIdcard());
		}
		return root;
	}  
}
