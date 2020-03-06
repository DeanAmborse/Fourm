package com.Esport.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.Esport.work.dao")
public class EsportForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsportForumApplication.class, args);
	}

}
