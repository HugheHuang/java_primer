
/**   
 * @author: Hughe 
 * @date: 2017年3月24日 下午6:40:00
 * @Package:   
 */

public class StringTest {

	/**
	 * @param args
	 */
	static void add(String str)
	{str+="!";}
	public static void main(String[] args) {
			
		String str=new String("123");
		add(str);
		System.out.println(str);
	}

}
