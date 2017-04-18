
public class Computer {
	

	private MainBoard mb;
	public Computer(MainBoard mb) {
		super();
		this.mb = mb;
	}

	public MainBoard getMb() {
		return mb;
	}

	public void setMb(MainBoard mb) {
		this.mb = mb;
	}
	public void start(){
		 mb.run();
		 System.out.println("windows~~~~");
		
	}
}
