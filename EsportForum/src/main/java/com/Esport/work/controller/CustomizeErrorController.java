package com.Esport.work.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomizeErrorController implements ErrorController{

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error";
	}
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView errorHtml(HttpServletRequest request,Model model) {
		HttpStatus status = getStatus(request);
		if(status.is4xxClientError()) {
			model.addAttribute("message","您想看的咱这没有啊T_T");
		}
		if(status.is5xxServerError()) {
			model.addAttribute("message", "诶？服务竟然冒烟了，请您先看看别的，我们赶快修理！！！");
		}
		return new ModelAndView("error");
	}
	HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if(statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception e) {
			// TODO: handle exception
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}	
