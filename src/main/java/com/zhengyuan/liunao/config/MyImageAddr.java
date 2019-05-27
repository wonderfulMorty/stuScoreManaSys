package com.zhengyuan.liunao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zhengyuan.liunao.tools.MyTool;

/**
 * 自定义的图片路径
 * 
 * @author pzr
 *
 */
@Configuration
public class MyImageAddr extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// addResourceHandler中的是访问路径，可以修改为其他的字符串 // addResourceLocations中的是实际路径
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + MyTool.getImg());
		super.addResourceHandlers(registry);

	}
}