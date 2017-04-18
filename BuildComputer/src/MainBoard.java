
public class MainBoard {
     private String band;
	private InterCompany cpu;
     private NvidaCompany videoCard;
     public MainBoard(String band, InterCompany cpu, NvidaCompany videoCard) {
		super();
		this.band = band;
		this.cpu = cpu;
		this.videoCard = videoCard;
	}
	public String getBand() {
		return band;
	}
	public InterCompany getCpu() {
		return cpu;
	}
	public NvidaCompany getVideoCard() {
		return videoCard;
	}
	public void run(){
		System.out.println(band+"run");
		cpu.operation();
		videoCard.display();
	}
	public void setBand(String band) {
		this.band = band;
	}
	public void setCpu(InterCompany cpu) {
		this.cpu = cpu;
	}
	public void setVideoCard(NvidaCompany videoCard) {
		this.videoCard = videoCard;
	}
		
	
	
}
