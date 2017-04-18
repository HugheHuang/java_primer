
public class UserManager {
	User[] users;
	private int nums;
	public UserManager(int size){
		nums=0;
		users=new User[size];
	}
	public void add(User user){
		//判断越界
		if(nums>=users.length){
			 System.out.println("can't add");
			 return;
		}
		//判断存在
		/*for(int i=0;i<nums;i++){
			if(user.getName().equals(users[i].getName())){
				System.out.println("exist error");
				return;
			}
		}*/
		User u=this.load(user.getName());
		if(u!=null) {
			System.out.println("exist! create fail");
			return;
		}
		System.out.println("create success");
		users[nums]=user;
		nums++;
	}
	public void update(User user){
		//根据用户名找到用户对象
		User u=load(user.getName());
		if(u==null){
			System.out.println("the object not exist");
			return;
		}
		//将要修改的用户对象的值设置到原有对象中
		if(user.getPassword()!=null){
			u.setPassword(user.getPassword());
			System.out.println("password change success!");
		}
		if(user.getAge()!=0){
			u.setAge(user.getAge());
			System.out.println("age change success!");
		}
	}
	public void delete(String username){
		//先找出Username位置
		int index=-1;
		for(int i=0;i<nums;i++){
			User u=users[i];
			if(username.equals(u.getName()))
				index=i;
		}
		if(index==-1) {
			System.out.println("not exist");
			return;
		}
		for(int i=index;i<nums-1;i++){
			users[i]=users[i+1];
		}
		users[--nums]=null;
		
		
	}
	public User load(String username){
		for(int i=0;i<nums;i++){
			User u=users[i];
			if(username.equals(u.getName())){
				return u;
			}
		}
		return null;
	}
	public void login(String username,String password){
		//1.判断用户是否存在
		User u=this.load(username);
		if(u==null){
			System.out.println("no exist!");
			return ;
		}
		//2.判断密码
		if(!u.getPassword().equals(password)){
			System.out.println("password error!");
			return;
		}
		//3.登陆成功
		System.out.println("Welcome!");
	}
	
	public User[] list(){
		User[] tus=new User[nums];
		for(int i=0;i<nums;i++){
			tus[i]=users[i];
		}
		return tus;
		// return users ;//不建议如此返回 因为会把nums返回
	}
}
