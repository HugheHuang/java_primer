import java.util.Comparator;

public class SongNameCompare implements Comparator<Song> {

	public int compare(Song o1, Song o2) {
		return o1.getName().compareTo(o2.getName());
	}

	
		
}
