package com.Esport.work.entity;

public class Post {
	private String pid;
	private String ptitle;
	private String pbody;
	private Long psendtime;
	private String tag;
	private String username;
	private Integer view_count;
	private Integer comment_count;
	private Integer like_count;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
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
	public Long getPsentTime() {
		return psendtime;
	}
	public void setPsentTime(Long psendtime) {
		this.psendtime = psendtime;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getPsendtime() {
		return psendtime;
	}
	public void setPsendtime(Long psendtime) {
		this.psendtime = psendtime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public Post() {}
	public Post(String pid, String ptitle, String pbody, Long psendtime, String tag, String username, Integer view_count,
			Integer comment_count, Integer like_count) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
		this.pbody = pbody;
		this.psendtime = psendtime;
		this.tag = tag;
		this.username = username;
		this.view_count = view_count;
		this.comment_count = comment_count;
		this.like_count = like_count;
	}
	
}
