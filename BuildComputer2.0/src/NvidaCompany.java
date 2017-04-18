
public class NvidaCompany extends Videocard {
	public NvidaCompany(int memmory,String type){
		super();
		this.setMemmory(memmory);
		this.setType(type);
	}
	
	public void display(){
		System.out.println("Nvida Videocard:"+this.getType()+","+this.getMemmory()+"MB");
	}
	
	
}