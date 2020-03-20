package com.Esport.work.Enum;

public enum CommentTypeEnum {
	
	POST(1),
	COMMENT(2);
	private Integer type;
	
	public Integer getType() {
		return type;
	}
	
	CommentTypeEnum(Integer type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public static boolean isExist(Integer type) {
		for(CommentTypeEnum commentTypeEnum :CommentTypeEnum.values()) {
			if(commentTypeEnum.getType() == type) {
				return true;
			}
		}
		return false;
	}
}
