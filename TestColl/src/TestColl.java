import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestColl {

	public static void main(String[] args) {
		//Set和List都可以
		//快速添加列表
		List<String> songs =new ArrayList<String>();
		//Set<String> songs =new HashSet<String>();
		Collections.addAll(songs, "咸鱼","倔强","蜗牛","野子","栀子花开");
		printList(songs);
		System.out.println();
		//正序排序
		Collections.sort(songs);
		printList(songs);
		System.out.println();
		//随机排序
		Collections.shuffle(songs);
		printList(songs);
		System.out.println();
		//反向排序
		Collections.reverse(songs);
		printList(songs);
		System.out.println();
		//交换
		Collections.swap(songs, 0, 1);
		printList(songs);
	}
	
	public static void printList(Collection<String> e){
		for(String str:e){
			System.out.println(str);
		}
	}
}
