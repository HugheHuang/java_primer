
public class TestDivide2 {

	public static void main(String[] args) {
		int c=divide(18,0);
		System.out.println(c);

	}
	
	public static int divide (int a,int b){
		int result=0;
		try{
			 System.out.println("before");
			 result =a/b;
			 System.out.println("after");
			 System.out.println("end exception");
			 return result;
		} catch (ArithmeticException e){
			//��ӡ��Ӧ�쳣������Ϣ,message��exception������
			System.out.println(e.getMessage());
			//��ӡ�쳣�����Ĺ켣
			e.printStackTrace();
		}
		return 10;
	}
}
