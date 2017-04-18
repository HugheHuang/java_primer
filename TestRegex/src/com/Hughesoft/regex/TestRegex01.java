package com.Hughesoft.regex;

public class TestRegex01 {

	public static void main(String[] args) {
		//"."表示任意字符
		System.out.println("a".matches("."));
		//正则表达式时用来匹配字符而不是字符串
		System.out.println("aa".matches("."));
		System.out.println("aa".matches(".a"));
		System.out.println("aa".matches(".."));
		
		// "\\d"表示是数字
		// "\\D"表示非数字
		System.out.println("123".matches("\\d\\d\\d"));
		System.out.println("1a32c".matches("\\d\\D\\d\\d\\D"));
		
		
		// "\\s"表示空白字符
		// "\\S"表示非空白字符
		System.out.println("1 2 d".matches("\\d\\s\\d\\sd"));
		
		//"\\w"表示常规字符:a-z,A-Z,0-9,_
		//"\\W"与其相反
		System.out.println("aa b1 22".matches("\\w\\w\\s\\w\\w\\s\\w\\w"));
	
		//在[]里面
		System.out.println("a".matches("[abcd]"));
		System.out.println("w".matches("[a-z]"));
		System.out.println("C".matches("[a-zA-z]"));
		//不在[]里面
		System.out.println("C".matches("[^a-zA-z]"));
		
		//支持或且非
		System.out.println("a".matches("[a-z&&[def]]"));
		System.out.println("D".matches("[a-z]||[A-Z]"));
		
	}

}
