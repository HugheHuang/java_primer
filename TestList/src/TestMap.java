import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		//Map存储的是键值对,key和value
		Map<Integer,String> maps=new HashMap();
		//使用put方法添加值
		maps.put(1, "hehe");
		maps.put(2, "lala");
		maps.put(3, "yoyo");
		//使用get(key)得到value
		System.out.println(maps.get(3));
		//keySet可以将maps中的key转换为Set的一组列表
		Set<Integer> keys=maps.keySet();
		//遍历Set可以得到相应的key,使用maps.get(key)可以得到value
		for(Integer i:keys){
			System.out.println(maps.get(i));
		}
		System.out.println("==========");
		//此时不会增加,会覆盖
		maps.put(3,"gege");
		keys=maps.keySet();
		for(Integer i:keys){
			System.out.println(maps.get(i));
		}
		System.out.println("==========");
		//判断值是否存在
		System.out.println(maps.containsKey(1));
		System.out.println(maps.containsValue("lala"));
		System.out.println(maps.containsValue("456"));
	}

}
