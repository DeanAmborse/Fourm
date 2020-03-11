package com.Esport.work.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Esport.work.entity.PostDTO;
import com.Esport.work.entity.UserState;
import com.Esport.work.service.PostService;
import com.Esport.work.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@GetMapping(value="/")
	public String index(HttpServletRequest request,Model model) {
		Cookie[] cookies = request.getCookies();
		if(cookies !=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("token")) {
					String token = cookie.getValue();
					UserState uState = userService.findByToken(token);
					if(uState !=null) {
						request.getSession().setAttribute("users", uState);
					}
					break;
				}
			}
		}
		List<PostDTO> postList = postService.list();
		model.addAttribute("posts", postList);
		return "index";
	}
	@GetMapping(value="/publish")
	public String publish() {
		return "publish";
	}
}
