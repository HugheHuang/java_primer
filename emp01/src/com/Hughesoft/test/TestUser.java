package com.Hughesoft.test;

import java.util.List;

import org.dom4j.Document;

import com.Hughesoft.dao.UsersDao;
import com.Hughesoft.model.User;
import com.Hughesoft.util.XMLUtil;

public class TestUser {
	private static UsersDao ud=new UsersDao();
	public static void main(String[] args) {
		//testAdd();
		//testLoad();
		//testDelete();
		//testUpdate();
		testList();
	}
	
	public static void testSingleton(){
		//测试单例
		Document d1=XMLUtil.getUserDocument();
		Document d2=XMLUtil.getUserDocument();
		System.out.println(d1==d2);
	}
	
	public static void testLoad(){
		User u=ud.load("bajie");
		//if(u==null) System.out.println("err");
		//else
		System.out.println(u);
	}
	
	public static void testAdd(){
		User u=new User();
		u.setNickname("悟空");
		u.setPassword("234");
		u.setUsername("wukong");
		ud.add(u);
	}
	public static void testDelete(){
		ud.delete("zhangsan");
	}
	public static void testUpdate(){
		User u=new User();
		u.setNickname("孙悟空");
		u.setPassword("123");
		u.setUsername("wukong1");
		ud.update(u);
	}
	
	public static void testList(){
		List<User> users=ud.list();
		for(User u:users){
			System.out.println(u);
		}
	}
}
