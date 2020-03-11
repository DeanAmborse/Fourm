package com.Esport.work.entity;

public class PostDTO {
	private Integer pid;
	private String ptitle;
	private String pbody;
	private String psendtime;
	private String tag;
	private String creatorID;
	private Integer view_count;
	private Integer comment_count;
	private Integer like_count;
	private Users users;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPbody() {
		return pbody;
	}
	public void setPbody(String pbody) {
		this.pbody = pbody;
	}
	public String getPsendtime() {
		return psendtime;
	}
	public void setPsendtime(String psendtime) {
		this.psendtime = psendtime;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCreatorID() {
		return creatorID;
	}
	public void setCreatorID(String creatorID) {
		this.creatorID = creatorID;
	}
	public Integer getView_count() {
		return view_count;
	}
	public void setView_count(Integer view_count) {
		this.view_count = view_count;
	}
	public Integer getComment_count() {
		return comment_count;
	}
	public void setComment_count(Integer comment_count) {
		this.comment_count = comment_count;
	}
	public Integer getLike_count() {
		return like_count;
	}
	public void setLike_count(Integer like_count) {
		this.like_count = like_count;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
}
