import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		//Map�洢���Ǽ�ֵ��,key��value
		Map<Integer,String> maps=new HashMap();
		//ʹ��put�������ֵ
		maps.put(1, "hehe");
		maps.put(2, "lala");
		maps.put(3, "yoyo");
		//ʹ��get(key)�õ�value
		System.out.println(maps.get(3));
		//keySet���Խ�maps�е�keyת��ΪSet��һ���б�
		Set<Integer> keys=maps.keySet();
		//����Set���Եõ���Ӧ��key,ʹ��maps.get(key)���Եõ�value
		for(Integer i:keys){
			System.out.println(maps.get(i));
		}
		System.out.println("==========");
		//��ʱ��������,�Ḳ��
		maps.put(3,"gege");
		keys=maps.keySet();
		for(Integer i:keys){
			System.out.println(maps.get(i));
		}
		System.out.println("==========");
		//�ж�ֵ�Ƿ����
		System.out.println(maps.containsKey(1));
		System.out.println(maps.containsValue("lala"));
		System.out.println(maps.containsValue("456"));
	}

}
