import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestColl {

	public static void main(String[] args) {
		//Set��List������
		//��������б�
		List<String> songs =new ArrayList<String>();
		//Set<String> songs =new HashSet<String>();
		Collections.addAll(songs, "����","��ǿ","��ţ","Ұ��","���ӻ���");
		printList(songs);
		System.out.println();
		//��������
		Collections.sort(songs);
		printList(songs);
		System.out.println();
		//�������
		Collections.shuffle(songs);
		printList(songs);
		System.out.println();
		//��������
		Collections.reverse(songs);
		printList(songs);
		System.out.println();
		//����
		Collections.swap(songs, 0, 1);
		printList(songs);
	}
	
	public static void printList(Collection<String> e){
		for(String str:e){
			System.out.println(str);
		}
	}
}
