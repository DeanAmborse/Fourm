package com.Esport.work.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Esport.work.DTO.CommentDTO;
import com.Esport.work.DTO.ResultDTO;
import com.Esport.work.entity.Comment;
import com.Esport.work.entity.UserState;
import com.Esport.work.exception.CustomizeErrorCode;
import com.Esport.work.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping(value="/comment",method = RequestMethod.POST)
	public Object post(@RequestBody CommentDTO commentDTO,
				HttpServletRequest request) {
		UserState uState = (UserState)request.getSession().getAttribute("users");
		if(uState == null) {
			return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
		}
		if(commentDTO == null||commentDTO.getContent()==null ||commentDTO.getContent()=="") {
			return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
		}
		Comment c = new Comment();
		c.setParentId(commentDTO.getParentId());
		c.setContent(commentDTO.getContent());
		c.setType(commentDTO.getType());
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		c.setCreateitime(dFormat.format(new Date()));
		c.setUpdatetime(c.getCreatetime());
		c.setLikecount(0);
		c.setCommentor(uState.getAccount_id());
		commentService.insert(c);
		return ResultDTO.okOf();
	}
}
