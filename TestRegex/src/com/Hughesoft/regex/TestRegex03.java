package com.Hughesoft.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex03 {

	public static void main(String[] args) {
		//可以先将一个正则表达式编译成为一个对象,可以提高效率
		Pattern p=Pattern.compile("\\d{4}");
		//通过Pattern可以获取一个Matcher对象,Matcher对象可以获取大量的有用信息
		Matcher m=p.matcher("233358-3232-1111");
		//判断是否匹配
		System.out.println(m.matches());
		//将查找的指针重置
		m.reset();
		//find指的是顺序匹配相应的字符
		//System.out.println(m.find());
		//每进行一次find,就可以将字符串通过group获取,一定要执行了find才能执行group
//		System.out.println(m.group());
//		System.out.println(m.find());
//		System.out.println(m.group());
//		System.out.println(m.find());
//		System.out.println(m.group());
		while(m.find()){
			//m.start()和m.end()可以获取匹配字符串开始与结束位置
			System.out.println(m.group()+"["+m.start()+","+m.end()+"]");
		}
	}

}
