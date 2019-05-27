package com.zhengyuan.liunao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2  
@ServletComponentScan

public class TestSpboot2Application {

	// 用spring 资源加载类 ResourceLoader
	public static void main(String[] args) {
		SpringApplication.run(TestSpboot2Application.class, args);
	}

	/*
	 * @Bean public MultipartResolver multipartResolver() { CommonsMultipartResolver
	 * multipartResolver = new CommonsMultipartResolver();
	 * multipartResolver.setMaxUploadSize(1000000); return multipartResolver; }
	 */

}
