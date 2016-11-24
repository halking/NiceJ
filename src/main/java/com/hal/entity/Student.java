package com.hal.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private Integer id;
	private String name;
	private int age;
	private String depart;
	private Date birthday;
	private String gender;

	public Student() {
		// TODO Auto-generated constructor stub
	}
    public	 Student(String name,int age,String depart){
    	this.name= name;
    	this.age = age;
    	this.depart = depart;
    }
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
  public String toString(){
	return "name:"+this.name+
			 "\n age:"+this.age+"\n depart:"+this.depart;
  }
  
  public void writeSome(String name){
	  System.out.println("name:"+name);
  }
  public void writeSome(String name,String depart){
	  System.out.println("name:"+name+"\t depart:"+depart);
  }
}
