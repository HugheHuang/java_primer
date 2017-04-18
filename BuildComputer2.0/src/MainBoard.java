
public class MainBoard {
     private String band;
	 private CPU cpu;
     private Videocard videoCard;
     public MainBoard(String band, InterCompany cpu, NvidaCompany videoCard) {
		super();
		this.band = band;
		this.cpu = cpu;
		this.videoCard = videoCard;
	}
	
	public void run(){
		System.out.println(band+"run");
		cpu.operation();
		videoCard.display();
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	public Videocard getVideoCard() {
		return videoCard;
	}

	public void setVideoCard(Videocard videoCard) {
		this.videoCard = videoCard;
	}
	
		
	
	
}
