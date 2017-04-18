class Song implements Comparable<Song> {
	private String name;
	private String singer;
	private int id;
	
	public Song(String name, String singer, int id) {
		super();
		this.name = name;
		this.singer = singer;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public Song() {
		super();
	}
	public int compareTo(Song o) {
		//会使用this和o比较,如果返回值>1顺序排序;
		//返回值<1倒序排序
		/*if(this.id>o.id) return 1;
		else if(this.id<o.id) return -1;
		else return 0;
		*/
		
		return this.getName().compareTo(o.getName());	
		}
	
	public String toString(){
		return "Song [id="+id+", name="+name+", singer="+singer+"]";
	}
	
}