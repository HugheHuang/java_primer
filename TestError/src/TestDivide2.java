
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
			//打印相应异常错误信息,message是exception的属性
			System.out.println(e.getMessage());
			//打印异常发生的轨迹
			e.printStackTrace();
		}
		return 10;
	}
}
