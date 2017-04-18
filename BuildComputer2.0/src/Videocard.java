
public abstract class Videocard {
	private int memmory;
	private String type;
	public int getMemmory() {
		return memmory;
	}
	public void setMemmory(int memmory) {
		this.memmory = memmory;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public abstract void display();
}
