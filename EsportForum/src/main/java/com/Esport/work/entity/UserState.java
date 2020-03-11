package com.Esport.work.entity;

public class UserState {
	private Long id;
	private String username;
	private String token;
	private String account_id;
	private String create_GMT;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getCreate_GMT() {
		return create_GMT;
	}
	public void setCreate_GMT(String create_GMT) {
		this.create_GMT = create_GMT;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserState [id=" + id + ", username=" + username + ", token=" + token + ", account_id=" + account_id
				+ ", create_GMT=" + create_GMT + "]";
	}
	public UserState(Long id, String username, String token, String account_id, String create_GMT, Long modified_GMT) {
		super();
		this.id = id;
		this.username = username;
		this.token = token;
		this.account_id = account_id;
		this.create_GMT = create_GMT;
	}
	public UserState() {
		
	}
}
