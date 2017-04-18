import java.util.Comparator;

public class SongIdCompare implements Comparator<Song> {

	public int compare(Song o1, Song o2) {
		return o1.getId()>o2.getId()?1:(o1.getId()<o2.getId()?-1:0);
	}
	
}
