package com.Hughesoft.regex;

public class TestRegex01 {

	public static void main(String[] args) {
		//"."��ʾ�����ַ�
		System.out.println("a".matches("."));
		//������ʽʱ����ƥ���ַ��������ַ���
		System.out.println("aa".matches("."));
		System.out.println("aa".matches(".a"));
		System.out.println("aa".matches(".."));
		
		// "\\d"��ʾ������
		// "\\D"��ʾ������
		System.out.println("123".matches("\\d\\d\\d"));
		System.out.println("1a32c".matches("\\d\\D\\d\\d\\D"));
		
		
		// "\\s"��ʾ�հ��ַ�
		// "\\S"��ʾ�ǿհ��ַ�
		System.out.println("1 2 d".matches("\\d\\s\\d\\sd"));
		
		//"\\w"��ʾ�����ַ�:a-z,A-Z,0-9,_
		//"\\W"�����෴
		System.out.println("aa b1 22".matches("\\w\\w\\s\\w\\w\\s\\w\\w"));
	
		//��[]����
		System.out.println("a".matches("[abcd]"));
		System.out.println("w".matches("[a-z]"));
		System.out.println("C".matches("[a-zA-z]"));
		//����[]����
		System.out.println("C".matches("[^a-zA-z]"));
		
		//֧�ֻ��ҷ�
		System.out.println("a".matches("[a-z&&[def]]"));
		System.out.println("D".matches("[a-z]||[A-Z]"));
		
	}

}
