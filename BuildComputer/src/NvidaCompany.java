
public class NvidaCompany {
	
	private int memmery;
	private String type;
	public NvidaCompany(int memmery, String type) {
		super();
		this.memmery = memmery;
		this.type = type;
	}
	public void display(){
		
		System.out.println(type+":"+memmery+"Mb");
	}
	public int getMemmery() {
		return memmery;
	}
	public String getType() {
		return type;
	}
	public void setMemmery(int memmery) {
		this.memmery = memmery;
	}
	public void setType(String type) {
		this.type = type;
	}
}
