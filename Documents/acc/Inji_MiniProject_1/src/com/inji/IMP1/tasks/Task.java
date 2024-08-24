package com.inji.IMP1.tasks;

import java.util.Date;

public class Task {

	private int no;
	private String title;
	private String description;
	private String status;
	private String priority;
	private Date startdate;
	private Date duedate;
	private String user_id;
	
	private String startdate2;
	private String duedate2;
	
	public String getStartdate2() {
		return startdate2;
	}

	public void setStartdate2(String startdate2) {
		this.startdate2 = startdate2;
	}

	public String getDuedate2() {
		return duedate2;
	}

	public void setDuedate2(String duedate2) {
		this.duedate2 = duedate2;
	}

	public Task(int no, String title, String description, String status, String priority, String startdate2, String duedate2, String user_id) {
		super();
		this.no = no;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.user_id = user_id;
		this.startdate2 = startdate2;
		this.duedate2 = duedate2;
	}
	
	public Task(String user_id, String title, String description, String priority, String startdate2, String duedate2) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.startdate2 = startdate2;
		this.duedate2 = duedate2;
	}
	
	public Task(String user_id, int no, String status) {
		super();
		this.user_id = user_id;
		this.no = no;
		this.status = status;
	}

	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	public Task(String user_id, int no)  {
		super();
		this.user_id = user_id;
		this.no = no;
	}
	
	public Task(String user_id, int no, String title, String description, String status, String priority, Date startdate, Date duedate) {
		super();
		this.user_id = user_id;
		this.no = no;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.startdate = startdate;
		this.duedate = duedate;
	}

	public Task(int no, String title, String description, String status, String priority, Date startdate, Date duedate, String user_id) {
		super();
		this.no = no;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.startdate = startdate;
		this.duedate = duedate;
		this.user_id = user_id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String discription) {
		this.description = discription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
