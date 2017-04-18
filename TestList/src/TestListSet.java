import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestListSet {

	public static void main(String[] args) {
		/*List<String> list=new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("aaa");
		for(String str:list){
			System.out.println(str);
		}
		System.out.println("===============");
		Set<String> set=new HashSet<String>();
		set.add("111");
		set.add("222");
		set.add("333");
		set.add("444");
		set.add("555");
		set.add("666");
		set.add("777");
		set.add("111");
		set.add("100");
		set.add("888");
		for(String str:set){
			System.out.println(str);
			String[]={"dd"};
			
			List list={};
		}*/
		
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,9,8,2,3,2,3,4);
		//法一Set<Integer> set=new HashSet(list);
		//法二
		Set<Integer> set=new HashSet();
		set.addAll(list);
		for(Integer num:set){
			System.out.println(num);
		}
	}

}
