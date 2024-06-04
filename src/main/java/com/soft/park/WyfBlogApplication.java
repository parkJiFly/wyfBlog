package com.soft.park;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(scanBasePackages = "com.soft.park")
@MapperScan("com.soft.park.mapper")
public class WyfBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WyfBlogApplication.class, args);
	}

}
