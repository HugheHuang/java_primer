package com.Hughesoft.regex;

public class TestRegex04 {

	public static void main(String[] args) {
		
		String str="25641685456fdaf544fsdf";
		//把数字用*代替
		System.out.println(str.replaceAll("\\d", "*"));
		//把数字用1个*代替
		//System.out.println(str.replaceAll("\\d", "*"));
		
	}

}
