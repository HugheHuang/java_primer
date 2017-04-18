
public class User {
     public User(String name, String password, String neckname, int age) {
		super();
		this.name = name;
		this.password = password;
		this.neckname = neckname;
		this.age = age;
	}
	 private String name;
     private String password;
     private String neckname;
     private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNeckname() {
		return neckname;
	}
	public void setNeckname(String neckname) {
		this.neckname = neckname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", neckname=" + neckname + ", age=" + age + "]";
	}
     
}
