package com.Hughesoft.regex;

public class TestRegex02 {

	public static void main(String[] args) {
		//*表示任意多个相同字符(0个或多个)
		System.out.println("aaaa".matches("a*"));
		//这个是false,因为*表示多个a
		System.out.println("abcd".matches("a*"));
		//这个是true
		System.out.println("abcd".matches("a.*"));
		//这个是true
		System.out.println("".matches("a*"));
		
		//+表示1个或者多个
		System.out.println("aa".matches("a+"));
		System.out.println("a".matches("a+"));
		System.out.println("".matches("a+"));
		
		//?表示0个或者1个
		System.out.println("aa".matches("a?"));
		System.out.println("a".matches("a?"));
		System.out.println("".matches("a?"));
		
		//X{n,m} 表示最少出现n次,最多出现m次
		System.out.println("2016-7-18".matches("\\d{4}-\\d{1,2}-\\d{1,2}"));
		
		//判断是否为数字
		System.out.println("224.4".matches("\\d+\\.\\d+"));
		
	}

}
