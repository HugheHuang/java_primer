
public class TestInteger {

	public static void main(String[] args) {
		//1.5֮���ṩ�Զ���װ
		Integer num1=10;
		//1.5֮ǰҪ����Integer��Ҫͨ�����캯��
		Integer num2=new Integer(10);
		
		//1.5֮����Զ���Integerת��Ϊint
		int num3=num1;
		//1.5֮ǰ��Ҫʹ��intValue()����
		int num4=num2.intValue();
		
		String str="123";
		System.out.println(str+1);
		//parseInt()��һ��static�ķ���
		//���Խ��ַ���ת��Ϊ����
		int a =Integer.parseInt(str);
		/*
		 * ����������װ����Ծ�����Ӧ��
		 * parseXX�����ַ���ת������Ӧ���͵�ֵ
		 */
		
	}

}
