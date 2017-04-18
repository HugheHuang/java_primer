
public class TestDivide {

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
		} catch (ArithmeticException e){
			System.out.println("can't divide 0");
		}
		System.out.println("end exception");
		return result;
	}
}
