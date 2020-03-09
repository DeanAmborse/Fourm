package com.Esport.work.controller;



import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.entity.UserState;
import com.Esport.work.entity.Users;
import com.Esport.work.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/loginPage")
	public String login() {
		return "login";	
	}
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,
						@RequestParam("password")String password,
						HttpServletResponse response) {
		Users u = userService.login(username, password);
		if(u != null) {
			UserState uState = new UserState();
			String token = UUID.randomUUID().toString();
			uState.setToken(token);
			uState.setAccount_id(String.valueOf(u.getId()));
			uState.setCreate_GMT(System.currentTimeMillis());
			uState.setModified_GMT(uState.getCreate_GMT());
			uState.setUsername(u.getUsername());
			userService.insert(uState);
			response.addCookie(new Cookie("token", token));
			return "redirect:/";
		}else {
			return "login";
		}	
	}
	@RequestMapping("/loginout")
	public String loginout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().removeAttribute("users");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("token")) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		return "redirect:/";
	}
	@RequestMapping(value="/registpage")
	public String Register() {
		return "register";
	}
	@RequestMapping(value="/registUser",method=RequestMethod.POST)
	public String register(Users users) {
		users.setMsg("registed");
		userService.register(users);
		return "redirect:/loginPage";
	}
}
