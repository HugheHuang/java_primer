import java.util.*;
public class TestSet {
	public static void main(String[] args) {
		Set<String> set =new HashSet<String>();
		set.add("123");
		set.add("456");
		set.add("789");
		
		/*Setû��˳��,������get����
		 * for(int i=0;i<set.size();i++){		
			String str=set.g
		}*/
		//����һ��������
		//����Collectionͨ��iterator��������������
		//�������м����඼���������
		//˳���������
		Iterator<String> it=set.iterator();
		//Iterator����hasNext�����Ԫ���Ƿ����
		while(it.hasNext()){
			//ͨ��next�������Ի�ȡ��һ��Ԫ��
			String str=it.next();
			System.out.println(str);
		}
   }
}
