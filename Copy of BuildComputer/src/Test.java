
public class Test {

	public static void main(String[] args) {
		MainBoard mb=new MainBoard("ASUS",new InterCompany(2.6,"Corel"),new NvidaCompany (2,"Rainbow"));
	
		Computer c=new Computer(mb);
		c.start();
		
	}

}
