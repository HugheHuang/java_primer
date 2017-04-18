package duotai;

public class Richman {
      private String name;
	  private Pet pet;
      public Richman(String name, Pet pet) {
		super();
		this.name = name;
		this.pet = pet;
	}
	public String getName() {
		return name;
	}
	public Pet getPet() {
		return pet;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public void play(){
		System.out.println(name+"Óë"+pet.getName()+"Íæ");
		pet.enjoy();
	}
}
