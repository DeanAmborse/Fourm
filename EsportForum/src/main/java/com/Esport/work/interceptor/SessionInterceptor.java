package com.Esport.work.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import com.Esport.work.entity.UserState;
import com.Esport.work.service.UserService;

public class SessionInterceptor implements HandlerInterceptor{
	
	@Autowired
	private UserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response
			, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
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
			return true;
		}else {
			return false;
		}
	}
	
}
