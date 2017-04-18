package com.Hughesoft.dao;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.Hughesoft.model.EmpException;
import com.Hughesoft.model.User;
import com.Hughesoft.util.XMLUtil;

public class UsersDao {
	private Document ud;
	public static final String USER_XML="users" ;
	public UsersDao() {
		ud=XMLUtil.getUserDocument();
	}
	private Element loadElementByUsername(String username){
		String path="/users/user[username='"+username+"']";
		Element e=(Element) ud.selectSingleNode(path);
		return e;
	}
	
	private  User element2User(Element e){
		User u=new User();
		u.setNickname(e.elementText("nickname"));
		u.setPassword(e.elementText("password"));
		u.setUsername(e.elementText("username"));
	return u;
	}
	
	public void add(User user){
		if(user.getUsername()==null||"".equals(user.getUsername())) throw new EmpException("用户名不能为空");
		User u=this.load(user.getUsername());
		if(u!=null) throw new EmpException("用户已经存在");
		Element e=ud.getRootElement().addElement("user");
		e.addElement("username").addText(user.getUsername());
		e.addElement("password").addText(user.getPassword());
		e.addElement("nickname").addText(user.getNickname());
		//XMLUtil.write2XML(ud, USER_XML);
		write();
	}
	private void write(){
		XMLUtil.write2XML(ud, "users");
	}
	public void delete(String username){
		//1.获取根节点
		Element root=ud.getRootElement();
		//2.获取Username节点
		Element u=loadElementByUsername(username);
		root.remove(u);
		write();
	}
	
	public void update(User user){
		//1.根据用户名获取节点
		Element e=loadElementByUsername(user.getUsername());
		if(e==null) throw new EmpException("要更新的用户不存在");
		//2.为这个节点修改数据
		e.element("password").setText(user.getPassword());
		e.element("nickname").setText(user.getNickname());
		write();
	}
	
	public User load(String username){
		Element e=loadElementByUsername(username);
		if(e==null) {return null;}
		User u=element2User(e);return u;
	}
	
	public List<User> list(){
		String path="/users/user";
		List<Element> eles=ud.selectNodes(path);
		List<User> users=new ArrayList<User>();
		for(Element e:eles){
			users.add(element2User(e));
		}
		return users;
	}
	
}
