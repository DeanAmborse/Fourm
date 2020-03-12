package com.Esport.work.entity;

import java.util.ArrayList;
import java.util.List;

public class PageDTO {
	private List<PostDTO> posts;
	private boolean showPrevious;
	private boolean showFirst;
	private boolean showNext;
	private boolean showEnd;
	private Integer page;
	private List<Integer> pages = new ArrayList<>();
	private Integer totalPage;
	public List<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(List<PostDTO> posts) {
		this.posts = posts;
	}

	public boolean isShowPrevious() {
		return showPrevious;
	}

	public void setShowPrevious(boolean showPrevious) {
		this.showPrevious = showPrevious;
	}

	public boolean isShowFirst() {
		return showFirst;
	}

	public void setShowFirst(boolean showFirst) {
		this.showFirst = showFirst;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public boolean isShowEnd() {
		return showEnd;
	}

	public void setShowEnd(boolean showEnd) {
		this.showEnd = showEnd;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void setPageDTO(Integer totalCount, Integer page2, Integer size) {
		// TODO Auto-generated method stub
		if(totalCount % size == 0) {
			totalPage = totalCount / size;
		}else {
			totalPage = totalCount / size + 1;
		}
		if(page2 < 1) {
			page2 = 1;
		}
		if(page2 >totalPage) {
			page2 = totalPage;
		}
		this.page = page2;
		pages.add(page2);
		for(int i = 1;i <= 3 ; i++) {
			if(page2 - i > 0) {
				pages.add(0, page2-i);
			}
			if(page2 + i <= totalPage) {
				pages.add(page2 + i);
			}
		}
		//是否展示上一页
		if(page2 == 1) {
			showPrevious = false;
		}else {
			showPrevious = true ;
		}
		//是否展示下一页
		if (page2 == totalPage) {
			showNext = false;
		}else {
			showNext = true;
		}
		//判断是否展示第一页
		if(pages.contains(1)) {
			showFirst = false;
		}else {
			showFirst = true;
		}
		//判断时候展示最后一页
		if(pages.contains(totalPage)) {
			showEnd = false;
		}else {
			showEnd = true;
		}
	}
	
}
