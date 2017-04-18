
public class TestStringBuilder {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder("abc");
		for(int i=0;i<1000;i++){
			sb.append(i);
		}
		System.out.println(sb.toString());
		
		String s1="123";
		String s2="456";
		String s3="789";
		StringBuilder sb1=new StringBuilder();
		
		//StringBuilder支持链式编程
		sb1.append(s1).append(s2);
		StringBuilder sb2=sb1;
		sb2.append(s3);
		System.out.println(sb1.toString());
	}

}
