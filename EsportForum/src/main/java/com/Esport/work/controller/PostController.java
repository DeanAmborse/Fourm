package com.Esport.work.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.entity.Post;
import com.Esport.work.entity.UserState;
import com.Esport.work.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	@PostMapping(value="/publishUser")
	public String publish(@RequestParam("ptitle") String ptitle
						 ,@RequestParam("pbody") String pbody
						 ,@RequestParam("tag") String tag
						 ,HttpServletRequest request) {
		Post post =new Post();
		post.setPtitle(ptitle);
		post.setPbody(pbody);
		post.setTag(tag);
		post.setPsentTime(System.currentTimeMillis());
		UserState uState = (UserState) request.getSession().getAttribute("users");
		post.setUsername(uState.getUsername());
		postService.Save(post);
		return "publish";
	}
}
