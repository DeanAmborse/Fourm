package com.Esport.work.entity;

public class Post {
	private Integer pid;
	private String ptitle;
	private String pbody;
	private String psendtime;
	private String updatetime;
	private String tag;
	private String creatorID;
	private Integer view_count;
	private Integer comment_count;
	private Integer like_count;
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
	
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public void setCreatorID(String creatorID) {
		this.creatorID = creatorID;
	}
	
	public Post(Integer pid, String ptitle, String pbody, String psendtime, String updatetime, String tag,
			String creatorID, Integer view_count, Integer comment_count, Integer like_count) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
		this.pbody = pbody;
		this.psendtime = psendtime;
		this.updatetime = updatetime;
		this.tag = tag;
		this.creatorID = creatorID;
		this.view_count = view_count;
		this.comment_count = comment_count;
		this.like_count = like_count;
	}
	public Post() {}
}
