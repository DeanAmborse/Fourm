package com.Esport.work.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer{
	@Bean
	public SessionInterceptor sessionInterceptor() {
		return new SessionInterceptor();
	}
 	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**")
		.excludePathPatterns("/static/**","/loginPage","/registpage")
		.excludePathPatterns("/","/loginUser","/registUser");
	}
}
