
public class UserManager {
	User[] users;
	private int nums;
	public UserManager(int size){
		nums=0;
		users=new User[size];
	}
	public void add(User user){
		//�ж�Խ��
		if(nums>=users.length){
			 System.out.println("can't add");
			 return;
		}
		//�жϴ���
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
		//�����û����ҵ��û�����
		User u=load(user.getName());
		if(u==null){
			System.out.println("the object not exist");
			return;
		}
		//��Ҫ�޸ĵ��û������ֵ���õ�ԭ�ж�����
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
		//���ҳ�Usernameλ��
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
		//1.�ж��û��Ƿ����
		User u=this.load(username);
		if(u==null){
			System.out.println("no exist!");
			return ;
		}
		//2.�ж�����
		if(!u.getPassword().equals(password)){
			System.out.println("password error!");
			return;
		}
		//3.��½�ɹ�
		System.out.println("Welcome!");
	}
	
	public User[] list(){
		User[] tus=new User[nums];
		for(int i=0;i<nums;i++){
			tus[i]=users[i];
		}
		return tus;
		// return users ;//��������˷��� ��Ϊ���nums����
	}
}
