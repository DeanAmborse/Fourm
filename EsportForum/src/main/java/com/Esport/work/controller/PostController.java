package com.Esport.work.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.entity.Post;
import com.Esport.work.entity.UserState;
import com.Esport.work.service.PostService;
import com.Esport.work.service.UserService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;
	@PostMapping("/publish")
	public String doPublish(@RequestParam(value="ptitle") String ptitle
						,@RequestParam(value="pbody") String pbody
						,@RequestParam(value="tag") String tag
						,HttpServletRequest request
						) {
		UserState uState = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("token")) {
					String token = cookie.getValue();
					uState = userService.findByToken(token);
					if(uState !=null) {
						request.getSession().setAttribute("users", uState);
					}
					break;
				}
			}
		}else {
			return "publish";
		}
		Post post = new Post();
		post.setPtitle(ptitle);
		post.setPbody(pbody);
		post.setTag(tag);
		post.setCreator(uState.getAccount_id());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		post.setPsendtime(df.format(new Date()));
		post.setLike_count(0);
		post.setView_count(0);
		post.setComment_count(0);
		postService.save(post);
		return "redirect:/";
	}
}
