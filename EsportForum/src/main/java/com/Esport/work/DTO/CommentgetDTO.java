package com.Esport.work.DTO;

import com.Esport.work.entity.Users;

public class CommentgetDTO {
	private Integer id;
	private Integer parentId;
	private Integer type;
	private String commentor;
	private String createtime;
	private String updatetime;
	private Integer likecount;
	private String content;
	private Users users;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCommentor() {
		return commentor;
	}
	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getLikecount() {
		return likecount;
	}
	public void setLikecount(Integer likecount) {
		this.likecount = likecount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
}
