package com.zhengyuan.liunao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyProperties {
	@Value("${cn.domain}")
	private String name;

	@Value("${cn.my.description}")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
