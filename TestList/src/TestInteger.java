
public class TestInteger {

	public static void main(String[] args) {
		//1.5之后提供自动封装
		Integer num1=10;
		//1.5之前要创建Integer需要通过构造函数
		Integer num2=new Integer(10);
		
		//1.5之后会自动将Integer转化为int
		int num3=num1;
		//1.5之前需要使用intValue()方法
		int num4=num2.intValue();
		
		String str="123";
		System.out.println(str+1);
		//parseInt()是一个static的方法
		//可以将字符串转换为整数
		int a =Integer.parseInt(str);
		/*
		 * 对于其他封装类而言均有相应的
		 * parseXX来将字符串转换成相应类型的值
		 */
		
	}

}
