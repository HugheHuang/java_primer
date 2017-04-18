package duotai;

public class Cat extends Pet {
	  public Cat(String name) {
			super();
			setName(name);
		}
	  
	  public void enjoy(){
		  System.out.println(getName()+" miaomiaomiao!");
	  }
}
