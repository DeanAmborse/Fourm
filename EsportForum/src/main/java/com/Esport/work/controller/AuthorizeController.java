package com.Esport.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Esport.work.entity.AccessTokenDTO;
import com.Esport.work.entity.GithubUser;
import com.Esport.work.provider.GithubProvider;

@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;
	@GetMapping("/callback")
	public String callback(@RequestParam(value="code") String code
						  ,@RequestParam(value="state") String state) {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClient_id("bba52e8c21784714cfa0");
		accessTokenDTO.setClient_secret("182433f9d66d300916e8dcd520f8629e2b992593");
		accessTokenDTO.setCode(code);
		accessTokenDTO.setRedirect_uri("http://localhost:8060/callback");
		String accessToken = githubProvider.getAccessToken(accessTokenDTO);
		GithubUser githubUser = githubProvider.getUser(accessToken);
		System.out.println(githubUser.getName());
		return "index";
		
	}
}
