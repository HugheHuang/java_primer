package com.Hughesoft.regex;

public class TestRegex02 {

	public static void main(String[] args) {
		//*��ʾ��������ͬ�ַ�(0������)
		System.out.println("aaaa".matches("a*"));
		//�����false,��Ϊ*��ʾ���a
		System.out.println("abcd".matches("a*"));
		//�����true
		System.out.println("abcd".matches("a.*"));
		//�����true
		System.out.println("".matches("a*"));
		
		//+��ʾ1�����߶��
		System.out.println("aa".matches("a+"));
		System.out.println("a".matches("a+"));
		System.out.println("".matches("a+"));
		
		//?��ʾ0������1��
		System.out.println("aa".matches("a?"));
		System.out.println("a".matches("a?"));
		System.out.println("".matches("a?"));
		
		//X{n,m} ��ʾ���ٳ���n��,������m��
		System.out.println("2016-7-18".matches("\\d{4}-\\d{1,2}-\\d{1,2}"));
		
		//�ж��Ƿ�Ϊ����
		System.out.println("224.4".matches("\\d+\\.\\d+"));
		
	}

}
