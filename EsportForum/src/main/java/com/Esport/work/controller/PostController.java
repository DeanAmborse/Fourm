package com.Esport.work.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.entity.Post;
import com.Esport.work.service.PostService;
import com.Esport.work.service.UserService;

@Controller
public class PostController {
	@Autowired
	private UserService userService;
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
		
		return "publish";
	}
}
