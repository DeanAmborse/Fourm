package com.Esport.work.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.DTO.CommentListDTO;
import com.Esport.work.DTO.PostDTO;
import com.Esport.work.entity.Post;
import com.Esport.work.entity.UserState;
import com.Esport.work.service.CommentService;
import com.Esport.work.service.PostService;
import com.alibaba.fastjson.JSONObject;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	@PostMapping("/publish")
	public String doPublish(@RequestParam(value="ptitle") String ptitle
						,@RequestParam(value="pbody") String pbody
						,@RequestParam(value="tag") String tag
						,@RequestParam(value="pid",required = false) Integer pid
						,HttpServletRequest request
						) {
		UserState uState = (UserState)request.getSession().getAttribute("users");
		if(uState == null) {
			return "redirect:/";
		}
		Post post = new Post();
		post.setPtitle(ptitle);
		post.setPbody(pbody);
		post.setTag(tag);
		post.setCreatorID(uState.getAccount_id());
		post.setPid(pid);
		post.setComment_count(0);
		post.setLike_count(0);
		post.setView_count(0);
		postService.saveORupdate(post);
		if(post.getPsendtime() != post.getUpdatetime()) {
			return "redirect:/my/myPost";
		}
		return "redirect:/";
	}
	@GetMapping("/post/{pid}")
	public String Post(@PathVariable(name = "pid") Integer pid,Model model) {
		Post post = postService.getbyId(pid);
		Post p = new Post();
		p.setPtitle(post.getPtitle());
		p.setPbody(post.getPbody());
		p.setPid(post.getPid());
		p.setPsendtime(post.getPsendtime());
		p.setTag(post.getTag());
		p.setView_count(post.getView_count()+1);
		int i = postService.upComment(pid);
		p.setComment_count(i);
		postService.saveORupdate(p);
		PostDTO postDTO = postService.getById(pid);
		CommentListDTO cListDTO = commentService.listByPid(pid);
		model.addAttribute("commentLists", cListDTO);
		model.addAttribute("post1", postDTO);
		return "post";
	}
	@GetMapping("/publish/{pid}")
	public String edit(@PathVariable(name="pid") Integer pid,Model model) {
		PostDTO postDTO = postService.getById(pid);
		model.addAttribute("title", postDTO.getPtitle());
		model.addAttribute("body", postDTO.getPbody());
		model.addAttribute("tag", postDTO.getTag());
		model.addAttribute("pid", postDTO.getPid());
		return "publish";
	}
}
