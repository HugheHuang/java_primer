
public class TestDivide3 {

	public static void main(String[] args) {
		int c=0;
		try{
			
			/*
			 * �˴����Ჶ���쳣,����û�д���
			 */
			c=divide(18, 0);
		}catch (ArithmeticException e){
			System.out.println(e.getMessage());
			}
		System.out.println(c);

	}
	
	public static int divide (int a,int b){
		//new ArithmeticException()���Դ���һ���쳣����,���Ҵ�����һ����Ϣ
		throw new ArithmeticException("this is i do �������׳����쳣");
	}
}
