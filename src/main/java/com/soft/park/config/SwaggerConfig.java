package com.soft.park.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/5 14:05
 * @description
 */
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
				.info(new Info()
						.title("wyfBlog文档")
						.description("文档学习")
						.contact(new Contact().name("wyf").email("1506825038@qq.com"))
						.version("v2.0"));
	}


}
