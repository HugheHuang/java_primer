import java.util.*;
public class TestList01 {

	public static void main(String[] args) {
		List list=new ArrayList();
		//通过add添加元素
		list.add("123");
		list.add("123");
		//通过remove移除元素
		list.remove("123");
		//nums.length
		//通过size()可以获取列表的长度
		for(int i=0;i<list.size();i++){
			//通过get可以获取某一个位置元素
			//get的元素是Obeject的,所以需要进行强制类型转换		
			String str=(String)list.get(i);
			System.out.println(str);
		}

	}

}
