package com.Hughesoft.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class TestWrite2XML {

	public static void main(String[] args) {
		XMLWriter out=null;
		try {
			//写数据首先创建Document对象
			Document d= DocumentHelper.createDocument();
			//为d添加节点,并且返回该节点
			Element root=d.addElement("users");
			//为根节点添加子节点,并返回节点
			Element eu=root.addElement("user");
			//添加属性
			eu.addAttribute("id", "1");
			//添加username和password
			eu.addElement("username").addText("张三");
			eu.addElement("password").addText("123");
			eu=root.addElement("user");
			eu.addAttribute("id", "2");
			eu.addElement("username").addText("李四");
			eu.addElement("password").addText("456");
			//获取xml文件所在路径
			String path=TestWrite2XML.class.getClassLoader().getResource("XML/users.xml").getPath();
			//在学习中可以使用方式
			path=path.replace("bin", "src");
			//创建XMLWriter来写数据,第二个参数表示输出格式
			out=new XMLWriter(new FileWriter(path),OutputFormat.createPrettyPrint());
			//将节点写到xml中
			out.write(d);
		 } catch (IOException e) {
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

}
