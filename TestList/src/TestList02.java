import java.util.*;
public class TestList02 {

	public static void main(String[] args) {
		//使用泛型后只能添加该类型的值
		List<String> list=new ArrayList<String>();
		list.add("abc");
		list.add("123");
		
		for(int i=0;i<list.size();i++){
			String str=list.get(i);
			System.out.println(str);
		}
		System.out.println();
		List<Integer> list2=new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		//此处如果仅仅使用remove(2)会移除下标为2的元素
		//如果要移除对象需要将2转换为Integer();
		
		Iterator<Integer>it=list2.iterator();
		for(;it.hasNext();){
			int num=it.next();
			System.out.println(num);
			/*if(num==2){
				list2.remove(new Integer(num));
			}*/
		}
		
		list2.remove(new Integer(2));
		
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i));
		}
		
		
	}

}
