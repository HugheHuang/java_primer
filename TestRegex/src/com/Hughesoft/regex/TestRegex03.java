package com.Hughesoft.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex03 {

	public static void main(String[] args) {
		//�����Ƚ�һ��������ʽ�����Ϊһ������,�������Ч��
		Pattern p=Pattern.compile("\\d{4}");
		//ͨ��Pattern���Ի�ȡһ��Matcher����,Matcher������Ի�ȡ������������Ϣ
		Matcher m=p.matcher("233358-3232-1111");
		//�ж��Ƿ�ƥ��
		System.out.println(m.matches());
		//�����ҵ�ָ������
		m.reset();
		//findָ����˳��ƥ����Ӧ���ַ�
		//System.out.println(m.find());
		//ÿ����һ��find,�Ϳ��Խ��ַ���ͨ��group��ȡ,һ��Ҫִ����find����ִ��group
//		System.out.println(m.group());
//		System.out.println(m.find());
//		System.out.println(m.group());
//		System.out.println(m.find());
//		System.out.println(m.group());
		while(m.find()){
			//m.start()��m.end()���Ի�ȡƥ���ַ�����ʼ�����λ��
			System.out.println(m.group()+"["+m.start()+","+m.end()+"]");
		}
	}

}
