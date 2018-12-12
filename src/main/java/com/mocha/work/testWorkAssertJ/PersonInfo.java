package com.mocha.work.testWorkAssertJ;

import java.util.Date;

public class PersonInfo {
	private String name;
    private int age;
    private Date birthDate;
	
    public PersonInfo()
    {
    	System.out.println("无参数构造方法实例");
    }
	
	public PersonInfo(final String name, final int age, final Date birthDate) {
		System.out.println("有参数构造方法实例");
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(final int age) {
		this.age = age;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "PersonInfo [name=" + name + ", age=" + age + ", birthDate=" + birthDate + "]";
	}
	
}
