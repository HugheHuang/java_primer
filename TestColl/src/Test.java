import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Song> songs =new ArrayList<Song>();
		songs.add(new Song("咸鱼","五月天",22));
		songs.add(new Song("倔强","五月天",13));
		songs.add(new Song("五环","小岳岳",44));
		songs.add(new Song("栀子花开","何炅",11));
		//Collections.sort(songs);
		Collections.sort(songs,new SongNameCompare());
		printList(songs);
		Collections.sort(songs,new SongSingerCompare());
		printList(songs);
		Collections.sort(songs,new SongIdCompare());
		printList(songs);
	}
	public static void printList(Collection<Song> e){
		for(Song str:e){
			System.out.println(str);
			}
	}
}

