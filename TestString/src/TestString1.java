
public class TestString1 {

	public static void main(String[] args) {
		String str1=new String("123");
		String str2=new String("123");
		//str1��str2ָ��ͬ�ڴ�
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		//str3��str4ָ����ͬ�ڴ�
		String str3="123";
		String str4="123";
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4));
		
		/*����string���ַ���������ÿ�½�һ���ַ����ͻ����һ���ڴ�
		��ʱ������ѭ�������100���ڴ棬����ֻ�����һ�鱻ʹ�ã�
		����String pool�е��ڴ治�ᱻ���ա�
		���Ի��д������ַ������ӣ��벻Ҫʹ�����з���
		*/
		String str6="";
		for(int i=0;i<1000;i++){
			str6+=i;
		}
		System.out.println(str6);
	}

}
