
public class TestString2 {

	public static void main(String[] args) {
		String str="hello";
		//获取某个位置的字符，从0开始
		System.out.println(str.charAt(1));
		
		String str2="heLLo";
		//大写转小写
		System.out.println(str2.toLowerCase());
		//小写转大写		
		System.out.println(str2.toUpperCase());
		//取字符串的长度
		System.out.println(str2.length());
		
		String str3="Hello world";
		//替换字符串
		System.out.println(str3.replace("world", "you"));
		//替换的原有字符不会变
		System.out.println(str3);
		//是否使用某个字符串开头,大小写敏感
		System.out.println(str3.startsWith("He"));
		//是否已某个字符串结尾,可以用于文件类型判断
		System.out.println(str3.endsWith("world"));
		
		String filename="aaa.txt";
		System.out.println(filename.endsWith("exe"));
		
		String str4="hello";
		String str5="Hello";
		System.out.println(str4.equals(str5));
		//忽略大小写进行比较
		System.out.println(str4.equalsIgnoreCase(str5));
		
		//去除字符串前面和后面的空格,中间的空格不去除.
		String str6="       skldfja odfada  ";
		System.out.println("|"+str6.trim()+"|");
	}

}
