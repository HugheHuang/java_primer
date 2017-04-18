import java.util.ArrayList;
import java.util.List;

public class UserManage {
		List<User> users;
		
     	public UserManage() {
			users=new ArrayList<User>();
			
		}
		public void add(User user){
     		if(this.load(user.getName())!=null){
     			System.out.println("user"+user.getName()+"exist! cannot add");
     			return;
     		}
     		users.add(user);
     		System.out.println(user.getNeckname()+"add succcess");
     	}
     	public void delete(String username){
     		//通过用户名找到对象
     		User u=this.load(username);
     		if(u==null){
     			System.out.println("not exist!delete fail");
     			return;
     		}
     		users.remove(u);
     	}
     	public void update(User user){
     		//找到用户对象
     		User u=this.load(user.getName());
     		if(u==null){
     			System.out.println("not exist!update fail");
     			return;
     		}
     		u.setAge(user.getAge());
     		u.setNeckname(user.getNeckname());
     		u.setPassword(user.getPassword());
     	}
     	public User load(String username){
     		for(User u:users){
     			if(username.equals(u.getName())){
     				return u;
     			}
     		}
     		return null;
     	}
     	public User login(String username,String password){
     		User u=this.load(username);
     		if(u==null){
     			System.out.println("not exist!login fail");
     			return null;
     		}
     		if(!password.equals(u.getPassword())){
     			System.out.println("password error!login fail");
     			return null;
     		}
     		System.out.println("welcome!");
     		return u;
     	}
		public List<User> HashList() {
			return null;
		}
     	
   
}
