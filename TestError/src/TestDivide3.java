
public class TestDivide3 {

	public static void main(String[] args) {
		int c=0;
		try{
			
			/*
			 * 此处将会捕获到异常,但是没有处理
			 */
			c=divide(18, 0);
		}catch (ArithmeticException e){
			System.out.println(e.getMessage());
			}
		System.out.println(c);

	}
	
	public static int divide (int a,int b){
		//new ArithmeticException()可以创建一个异常对象,并且传递了一个信息
		throw new ArithmeticException("this is i do 这是我抛出的异常");
	}
}
