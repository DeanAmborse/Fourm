package com.Esport.work.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
						HttpSession session,Model model) {
		Users u = userService.login(username, password);
		if(u != null) {
			session.setAttribute("users",u);
			return "redirect:/";
		}else {
			model.addAttribute("msg", "登录失败，请重新登录");
			return "login";
		}	
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
