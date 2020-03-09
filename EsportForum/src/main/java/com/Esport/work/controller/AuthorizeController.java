package com.Esport.work.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.entity.AccessTokenDTO;
import com.Esport.work.entity.GithubUser;
import com.Esport.work.entity.UserState;
import com.Esport.work.provider.GithubProvider;
import com.Esport.work.service.UserService;

@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;
	@Autowired
	private UserService userService;
	@GetMapping("/callback")
	public String callback(@RequestParam(value="code") String code
						  ,@RequestParam(value="state") String state
						  ,HttpServletResponse response) {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClient_id("bba52e8c21784714cfa0");
		accessTokenDTO.setClient_secret("182433f9d66d300916e8dcd520f8629e2b992593");
		accessTokenDTO.setCode(code);
		accessTokenDTO.setRedirect_uri("http://localhost:8060/callback");
		accessTokenDTO.setState(state);
		String accessToken = githubProvider.getAccessToken(accessTokenDTO);
		GithubUser githubUser = githubProvider.getUser(accessToken);
		if(githubUser != null) {
			UserState uState = new UserState();
			String token = UUID.randomUUID().toString();
			uState.setToken(token);
			uState.setAccount_id(String.valueOf(githubUser.getId()));
			uState.setCreate_GMT(System.currentTimeMillis());
			uState.setModified_GMT(uState.getCreate_GMT());
			uState.setUsername(githubUser.getName());
			userService.insert(uState);
			Cookie cookie = new Cookie("token", token);
			response.addCookie(cookie);
			return "redirect:/";
		}else{
			return "login";
		}
		
	}
}
