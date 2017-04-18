
public class TestString1 {

	public static void main(String[] args) {
		String str1=new String("123");
		String str2=new String("123");
		//str1和str2指向不同内存
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		//str3和str4指向相同内存
		String str3="123";
		String str4="123";
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4));
		
		/*由于string是字符串常量，每新建一个字符串就会分配一块内存
		此时，以下循环会分配100块内存，但是只有最后一块被使用，
		而且String pool中的内存不会被回收。
		所以会有大量的字符串叠加，请不要使用下列方法
		*/
		String str6="";
		for(int i=0;i<1000;i++){
			str6+=i;
		}
		System.out.println(str6);
	}

}
