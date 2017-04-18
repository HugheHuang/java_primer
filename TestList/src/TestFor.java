import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//ctrl+shilft+o  µ¼Èë°ü
public class TestFor {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("1001");
		
		for(String str:list){
			System.out.println(str);
		}
		System.out.println("=====================");
		Set<String> set=new HashSet<String>();
		set.add("abc");
		set.add("sdf");
		set.add("abcgabc");
		
		for(String str2:set){
			System.out.println(str2);
		}
		System.out.println("=====================");
		Integer[] nums={2,3,4,5,6};
		for(Integer a:nums){
			System.out.println(a);
		}
		
	}
}
