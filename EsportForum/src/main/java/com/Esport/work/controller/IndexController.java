package com.Esport.work.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.DTO.PageDTO;
import com.Esport.work.entity.UserState;
import com.Esport.work.service.PostService;

@Controller
public class IndexController {
	@Autowired
	private PostService postService;
	@GetMapping(value="/")
	public String index(HttpServletRequest request,Model model,
						@RequestParam(name="page",defaultValue = "1") Integer page,
						@RequestParam(name="size",defaultValue = "7") Integer size) {
		request.getSession().getAttribute("users");
		PageDTO pageDTO = postService.list(page,size);
		model.addAttribute("pageDTO", pageDTO);
		return "index";
	}
	@GetMapping(value="/publish")
	public String publish(HttpServletRequest request ,Model model) {
		UserState uState = (UserState)request.getSession().getAttribute("users");
		if(uState == null) {
			return "redirect:/loginPage";
		}
		return "publish";
	}
	@GetMapping("/my/{action}")
	public String myIndex(@PathVariable(name="action") String action,Model model
						 ,@RequestParam(name="page" ,defaultValue="1") Integer page
						 ,@RequestParam(name="size" ,defaultValue="7") Integer size
						 ,HttpServletRequest request) {
		UserState uState = (UserState)request.getSession().getAttribute("users");
		if(uState == null) {
			return "redirect:/";
		}
		if("myIndex".equals(action)) {
			model.addAttribute("section","myIndex");
			model.addAttribute("sectionName","我的空间");
		}else if ("myPost".equals(action)) {
			model.addAttribute("section","myPost");
			model.addAttribute("sectionName","我的帖子");
		}else if ("myReplies".equals(action)) {
			model.addAttribute("section","myReplies");
			model.addAttribute("sectionName","我的回复");
		}
		PageDTO pageDTO = postService.list1(uState.getAccount_id(),page, size);
		model.addAttribute("pageDTO1",pageDTO);
		return "user";
	}
}
