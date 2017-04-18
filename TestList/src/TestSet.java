import java.util.*;
public class TestSet {
	public static void main(String[] args) {
		Set<String> set =new HashSet<String>();
		set.add("123");
		set.add("456");
		set.add("789");
		
		/*Set没有顺序,不能用get方法
		 * for(int i=0;i<set.size();i++){		
			String str=set.g
		}*/
		//创建一个迭代器
		//由于Collection通过iterator方法创建迭代器
		//所以所有集合类都有这个方法
		//顺序是无序的
		Iterator<String> it=set.iterator();
		//Iterator中有hasNext来检查元素是否存在
		while(it.hasNext()){
			//通过next方法可以获取下一个元素
			String str=it.next();
			System.out.println(str);
		}
   }
}
