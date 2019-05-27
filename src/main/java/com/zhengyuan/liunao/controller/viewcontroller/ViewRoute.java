package com.zhengyuan.liunao.controller.viewcontroller;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Sys")
public class ViewRoute {
	@RequestMapping("/loginView")
	public String loginView(HttpSession httpSession) {
		
		return "login";
	}
	
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession httpSession) {
		httpSession.removeAttribute("name");
		httpSession.removeAttribute("account");
		httpSession.removeAttribute("photo");
		return "redirect:/Sys/loginView";
	}

	@RequestMapping("/adminIndex")
	public String adminIndex(HttpSession s) {
		String perssion = s.getAttribute("role").toString();
		if(perssion.equals("admin")) {
			return "adminIndex";
		}else {
			return "redirect:/Sys/loginView";
		}
	}
	
	@RequestMapping("/stuIndex")
	public String stuIndex() {
		return "stuIndex";
	}
	
	@RequestMapping("/teacherIndex")
	public String teacherIndex() {
		return "teacherIndex";
	}

	@RequestMapping("/teacherInfo")
	public String teacherInfo() {
		return "teacherInfo";
	}

	@RequestMapping("/stuInfo")
	public String stuInfo() {
		return "stuInfo";
	}
	
	@RequestMapping("/stuInfo_mf")
	public String stuInfo_mf() {
		return "stuInfo_mf";
	}
	

	@RequestMapping("/parseStu")
	public String parseStu() {
		return "parseStu";
	}

	@RequestMapping("/stuAdd")
	public String StuRegister() {
		return "stuAdd";
	}

	@RequestMapping("/stuModi")
	public ModelAndView stuModi(ModelAndView mav, @RequestParam("num") String num) {
		mav.addObject("num", num);
		mav.setViewName("stuModi");
		return mav;
	}
	
	
	@RequestMapping("/stuScore")
	public String stuScore() {
		return "stuScore";
	}
	
	
	@RequestMapping("/teaAdd")
	public String teaAdd() {
		return "teaAdd";
	}
	
	@RequestMapping("/teacherInfo_mf")
	public String teacherInfo_mf() {
		return "teacherInfo_mf";
	}
	
	
	
	@RequestMapping("/teaModi")
	public ModelAndView teaModi(ModelAndView mav, @RequestParam("num") String num) {
		mav.addObject("num", num);
		mav.setViewName("teaModi");
		return mav;
	}
	
	
	
	
	@RequestMapping("/claCouModi")
	public ModelAndView claCouModi(ModelAndView mav,  @RequestParam("coursename") String coursename,@RequestParam("num") String num) {
		mav.addObject("num", num);
		System.out.println(coursename);
		mav.addObject("coursename", coursename);
		mav.setViewName("claCouModi");
		return mav;
	}
	
	


	@RequestMapping("/claCouScore")
	public String claCouScore() {
		return "claCouScore";
	}

	@RequestMapping("/ClaCouSco")
	public String ClaCouSco() {
		return "ClaCouSco";
	}

	@RequestMapping("/ClaCouTea")
	public String ClaCouTea() {
		return "ClaCouTea";
	}
	
	@RequestMapping("/parseClaCouSco")
	public String parseClaCouSco() {
		return "parseClaCouSco";
	}
	

	@RequestMapping("/parseClaComp")
	public String parseClaComp() {
		return "parseClaComp";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/announce")
	public String announce() {
		return "announce";
	}
	
	
}
