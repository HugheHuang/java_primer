package com.Hughesoft.regex;

public class TestRegex04 {

	public static void main(String[] args) {
		
		String str="25641685456fdaf544fsdf";
		//��������*����
		System.out.println(str.replaceAll("\\d", "*"));
		//��������1��*����
		//System.out.println(str.replaceAll("\\d", "*"));
		
	}

}
