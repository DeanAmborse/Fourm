package com.Esport.work.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
	POST_NOT_FOUND(2000,"尴尬，您找的帖子没有了......"),
	TARGET_NOT_FOUND(2001,"未选中任何帖子或评论进行回复"),
	NO_LOGIN(2200,"用户未登录，无法进行评论哦！请先登录"),
	SYS_ERROR(2004,"诶，出错喽，有点尴尬"),
	TYPE_PARAM_WRONG(2005,"评论类型有误或者不存在"),
	COMMENT_NOT_FOUND(2006,"评论不存在"),
	CONTENT_IS_EMPTY(2007,"评论不能为空哦");
	private String message;
	private Integer code;
	CustomizeErrorCode(Integer code,String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.code = code;
	}
	@Override
	public String getMessage() {
		return message;
	}
	@Override
	public Integer getCode() {
		// TODO Auto-generated method stub
		return code;
	}
}
