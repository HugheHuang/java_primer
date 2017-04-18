
public class InterCompany {
	private double speed;
	private String type;
	public InterCompany(double speed, String type) {
		super();
		this.speed = speed;
		this.type = type;
	}
	public double getSpeed() {
		return speed;
	}
	public String getType() {
		return type;
	}
	public void operation(){
		System.out.println(type+": "+speed+"mHz");
		
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public void setType(String type) {
		this.type = type;
	}
}
