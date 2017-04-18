
public class TestString4 {

	public static void main(String[] args) {
		String word="this is my world my name";
		//通过字符串将其拆分为数组
		String[] strs=word.split(" ");
		System.out.println(strs.length);
		for(String str:strs){
			System.out.println(str);
		}
		String user="超级管理员,文章发布人员,系统用户";
		String [] rs=user.split(",");
		for(String r:rs){
			System.out.println(r);
		}
	}

}
