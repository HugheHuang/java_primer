import java.util.*;
public class TestList01 {

	public static void main(String[] args) {
		List list=new ArrayList();
		//ͨ��add���Ԫ��
		list.add("123");
		list.add("123");
		//ͨ��remove�Ƴ�Ԫ��
		list.remove("123");
		//nums.length
		//ͨ��size()���Ի�ȡ�б�ĳ���
		for(int i=0;i<list.size();i++){
			//ͨ��get���Ի�ȡĳһ��λ��Ԫ��
			//get��Ԫ����Obeject��,������Ҫ����ǿ������ת��		
			String str=(String)list.get(i);
			System.out.println(str);
		}

	}

}
