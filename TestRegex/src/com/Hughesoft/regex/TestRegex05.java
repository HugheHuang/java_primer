package com.Hughesoft.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex05 {

	public static void main(String[] args) {
		String str="532101197612210039,532122199802120034,534501198212110029";
		//使用括号进行分组
		Pattern p=Pattern.compile("(\\d{6})(\\d{8})\\d{4}");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println("生源地:"+m.group(1)+"出生日期"+m.group(2));
		}
		String h="<table><td>hello</td><td>大家好</td><td>每个人都好</td></table>";
		//贪婪模式,指的是.*会匹配所有的信息,此处会找整个信息
		p=Pattern.compile("<td>(.*)</td>");
		m=p.matcher(h);
		while(m.find()){
			System.out.println(m.group(1));
			System.out.println("["+m.start()+","+m.end()+"]");
		}
		//找到的结果:hello</td><td>大家好</td><td>每个人都好
		//非贪婪模式,仅仅是匹配第一个结尾,特别注意 ?加在*或者+之后就是非贪婪模式
		p=Pattern.compile("<td>(.*?)</td>");
		m=p.matcher(h);
		while(m.find()){
			System.out.println(m.group(1));
			System.out.println("["+m.start()+","+m.end()+"]");
		}
	}

}
