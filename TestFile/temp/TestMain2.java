public class TestMain2{
	public static void main(String[] args){
		if(args.length<2){
			System.out.println("请输入正确参数");
			return;
		}
		try{
			//字符串转换为int
			//转换时会抛出相应的NumberFormatException
			int r=Integer.parseInt(args[0])+Integer.parseInt(args[1]);
		System.out.println(r);
		}
		catch(NumberFormatException e){
			System.out.println("请输入正确参数");
		}
		
	}
}

