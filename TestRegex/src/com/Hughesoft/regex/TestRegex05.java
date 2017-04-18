package com.Hughesoft.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex05 {

	public static void main(String[] args) {
		String str="532101197612210039,532122199802120034,534501198212110029";
		//ʹ�����Ž��з���
		Pattern p=Pattern.compile("(\\d{6})(\\d{8})\\d{4}");
		Matcher m=p.matcher(str);
		while(m.find()){
			System.out.println("��Դ��:"+m.group(1)+"��������"+m.group(2));
		}
		String h="<table><td>hello</td><td>��Һ�</td><td>ÿ���˶���</td></table>";
		//̰��ģʽ,ָ����.*��ƥ�����е���Ϣ,�˴�����������Ϣ
		p=Pattern.compile("<td>(.*)</td>");
		m=p.matcher(h);
		while(m.find()){
			System.out.println(m.group(1));
			System.out.println("["+m.start()+","+m.end()+"]");
		}
		//�ҵ��Ľ��:hello</td><td>��Һ�</td><td>ÿ���˶���
		//��̰��ģʽ,������ƥ���һ����β,�ر�ע�� ?����*����+֮����Ƿ�̰��ģʽ
		p=Pattern.compile("<td>(.*?)</td>");
		m=p.matcher(h);
		while(m.find()){
			System.out.println(m.group(1));
			System.out.println("["+m.start()+","+m.end()+"]");
		}
	}

}
