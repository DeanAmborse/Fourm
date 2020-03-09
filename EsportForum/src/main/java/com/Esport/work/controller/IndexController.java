package com.Esport.work.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Esport.work.entity.UserState;
import com.Esport.work.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	@GetMapping(value="/")
	public String index(HttpServletRequest request) {
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
			return "index";
		}else {
			return "index";	
		}
	}
	@GetMapping(value="/publish")
	public String publish() {
		return "publish";
	}
}
