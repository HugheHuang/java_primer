package com.Hughesoft.XML;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sun.msv.relaxns.reader.RootGrammarState;

public class TestXPath {

	public static void main(String[] args) {
		try {
			SAXReader reader=new SAXReader();
			Document d=reader.read(Test04.class.getClassLoader().getResource("XML/Books.xml"));
			Element root= d.getRootElement();
			/**
			 * 相对路径查找,从当前节点查找子节点
			 */
			List<Element> eles=root.selectNodes("book");
			System.out.println(eles);
			/**
			 * 使用绝对路径来查找,从books节点查找book节点(此时不会去找book下的子节点)
			 */
			eles=root.selectNodes("/books/book");
			System.out.println(eles);
			/**
			 * 根节点不是book,所以找不到
			 */
			eles=root.selectNodes("/book");
			System.out.println(eles);
			/**
			 *   "//"表示从文档中遍历所有满足要求的节点(从根节点开始)
			 *   不太建议使用,因为效率不高
			 */
			eles=root.selectNodes("//book");
			System.out.println(eles);
			/**
			 * 查找了作者为Bruce Eckel的书
			 */
			eles=root.selectNodes("/books/book[author='Bruce Eckel']");
			for(Element e:eles){
				System.out.println(e.elementText("title"));
			}
			/**
			 * 查找属性中id>=2的书
			 */
			eles=root.selectNodes("/books/book[@id>=2]");
			for(Element e:eles){
				System.out.println(e.elementText("title"));
			}
			/**
			 * 查找名称中有java的价格节点
			 */
			eles=root.selectNodes("/books/book[contains(title,'java')]/price");
			for(Element e:eles){
				System.out.println(e.getTextTrim());
			}
			/**
			 * 查找名称中有java且价格小于50的节点
			 */
			eles=root.selectNodes("/books/book[contains(title,'java') and price<50]");
			for(Element e:eles){
				System.out.println(e.elementText("title")+":"+e.elementText("price"));
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
