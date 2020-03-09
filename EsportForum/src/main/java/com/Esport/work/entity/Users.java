package com.Esport.work.entity;


public class Users {
	private Long id;
	private String username;
	private String password;
	private String msg;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Users(Long id, String username, String password, String msg) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.msg = msg;
	}
	public Users(){}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", msg=" + msg + "]";
	}
	
}
