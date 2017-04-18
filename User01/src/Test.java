
public class Test {

	public static void main(String[] args) {
		UserManager um= new UserManager(5);
		um.add(new User("hehe","123","lala",43));
		um.add(new User("hehe","465","lala",43));
		um.add(new User("123","465","lala",43));
		um.add(new User("456","465","lala",43));
		um.add(new User("789","465","lala",43));
		um.add(new User("156","465","lala",43));
		um.add(new User("666","465","lala",43));
//		
//		User u=um.load("hehe");
//		System.out.println(u);
//		
//		User u2=new User("123","000","lala",33);
//		um.update(u2);
//		System.out.println(u2);
//		
//		um.login("hehe","456");
//		um.login("hehe","123");
//		um.login("99999","123");
//		
		um.delete("1000000");
		um.delete("hehe");
		
		User[] users=um.list();
		for(int i=0;i<users.length;i++){
			System.out.println(users[i]);
		}

}
}