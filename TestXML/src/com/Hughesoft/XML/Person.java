package com.Hughesoft.XML;

public class Person {
	private String name;
	private String sex;
	private String idcard;
	private int age;
	public String getName() {
		return name;
	}
	public Person(String name, String sex, String idcard, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
