
public class InterCompany extends CPU {
	
	public InterCompany(double speed, String type) {
		super();
		this.setType(type)  ;
		this.setSpeed(speed) ;
	}
	
	public void operation(){
		System.out.println(this.getType()+": "+this.getSpeed()+"mHz");
		
	}
	
	
}
