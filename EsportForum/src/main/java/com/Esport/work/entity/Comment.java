package com.Esport.work.entity;

public class Comment {
	private Integer id;
	private Integer parentId;
	private Integer type;
	private String commentor;
	private String createtime;
	private String updatetime;
	private Integer likecount;
	private String content;
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
	public void setCreateitime(String createtime) {
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
	public Comment(Integer id, Integer parentId, Integer type, String commentor, String createtime, String updatetime,
			Integer likecount, String content) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.type = type;
		this.commentor = commentor;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.likecount = likecount;
		this.content = content;
	}
	public Comment() {}
}
