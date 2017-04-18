public class TestMain{
	public static void main(String[] args){
		//args用来存储运行时的参数，可以在运行时指定相应的参数，使用空格来分割
		System.out.println(args.length);
		for(String arg:args){
			System.out.println(arg);
		}
	}
}
