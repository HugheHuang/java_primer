import java.util.Comparator;

public class SongSingerCompare implements Comparator<Song> {

	public int compare(Song o1, Song o2) {
		return o1.getSinger().compareTo(o2.getSinger());
	}

}
