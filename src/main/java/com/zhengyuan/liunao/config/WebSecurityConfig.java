package com.zhengyuan.liunao.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter{
	public static final String SESSION_KEY="name";
	 @Bean
	    public SecurityInterceptor getSecurityInterceptor(){
	        return  new SecurityInterceptor();
	    }
	    @Override
	    public  void addInterceptors(InterceptorRegistry registry){
	        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
	 
	        //排除配置
	        addInterceptor.excludePathPatterns("/Sys/loginView","/Sys/dealLogin","/Sys/css/**","/Sys/fonts/**","/Sys/images/**","/Sys/js/**","/Sys/lau/**","/Sys/lib/**");
	        //拦截配置
	        addInterceptor.addPathPatterns("/**/**");
	    }
	 
	    private class SecurityInterceptor extends HandlerInterceptorAdapter {
	        @Override
	        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws IOException{
	            HttpSession session = request.getSession(true);
	            //判断是否已有该用户登录的session
	            if(session.getAttribute("name") !=null){
	                return  true;
	            }
	            //跳转到登录页
	            String url = "/Sys/loginView";
	            response.sendRedirect(url);
	            return false;
	        }
	    }


}
