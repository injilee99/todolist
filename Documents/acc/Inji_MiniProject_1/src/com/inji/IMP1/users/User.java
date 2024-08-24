package com.inji.IMP1.users;

import java.util.Date;

public class User {
	private String id;
	private String name;
	private Date birth;

	private String birth2;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String birth2) {
		super();
		this.id = id;
		this.name = name;
		this.birth2 = birth2;
	}
	
	public User(String id) {
		super();
		this.id = id;
	}

	public String getBirth2() {
		return birth2;
	}

	public void setBirth2(String birth2) {
		this.birth2 = birth2;
	}

	public User(String id, String name, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
