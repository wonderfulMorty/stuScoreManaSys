package com.zhengyuan.liunao.controller.dealcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhengyuan.liunao.entity.Stu;
import com.zhengyuan.liunao.entity.Teacher;
import com.zhengyuan.liunao.service.TeacherService;
import com.zhengyuan.liunao.tools.Layui;

import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/Sys")
@Api("TeacherInfoDeal相关api")
public class TeacherInfoDeal {
	@Autowired
	TeacherService teacherService;

	int mylim;
	int mystart;

	@RequestMapping(value = "/getTeaInfo")
	@ResponseBody
	public Object getStuInfo(@RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		mylim = lim;
		mystart = start;
		System.out.println(mylim);
		System.out.println(mystart);
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("pagesize", lim);
		List<Teacher> allTeacher = teacherService.findAllTeacher(map);
		int total = teacherService.teacherCount();
		System.out.println(total);
		Layui l = Layui.data(total, allTeacher);
		return JSON.toJSON(l);
	}

	@RequestMapping(value = "/getTeaSimpleInfo")
	@ResponseBody
	public Object getTeaSimpleInfo(@RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		mylim = lim;
		mystart = start;
		System.out.println(mylim);
		System.out.println(mystart);
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("pagesize", lim);
		List<Teacher> allTeacher = teacherService.findAllTeacher(map);
		List<Teacher>teacher =  new ArrayList<>();
		for(int i=0;i<allTeacher.size();i++) {
			String teachno = allTeacher.get(i).getTeachno();
			String name = allTeacher.get(i).getName();
			String sex = allTeacher.get(i).getSex();
			teacher.add(new Teacher(teachno, name, sex));
		}
		int total = teacherService.teacherCount();
		System.out.println(total);
		Layui l = Layui.data(total, teacher);
		return JSON.toJSON(l);
	}
	
	
	
	
	
	@ApiOperation("获取教师的信息")

	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@RequestMapping("/getTeaByName")
	@ResponseBody
	public String getTeaByName(@RequestParam("key[id]") String name,@RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		mylim = lim;
		mystart = start;
		if (name.equals("")) {
			Map<String, Object> map = new HashMap<>();
			map.put("start", mystart);
			map.put("pagesize", mylim);
			List<Teacher> teacherList = teacherService.findAllTeacher(map);
			int total = teacherService.teacherCount();
			Layui l = Layui.data(total, teacherList);
			return JSON.toJSONString(l);
		} else {
			List<Teacher> teacherList = teacherService.findTeacherByName(name, mystart, mylim);
			int total = teacherList.size();
			Layui l = Layui.data(total, teacherList);
			System.out.println(JSON.toJSONString(l));
			return JSON.toJSONString(l);
		}

	}

	@RequestMapping("/getTeaByNum")
	@ResponseBody
	public String getTeaByNum(@RequestParam("num") String num) {
		List<Teacher> teaList = new ArrayList<>();
		teaList = teacherService.findTeacherByNum(num);
		int total = teaList.size();
		Layui l = Layui.data(total, teaList);
		System.out.println("getTeaByNum---->" + JSON.toJSONString(l));
		return JSON.toJSONString(l);

	}

	@RequestMapping("/updateTea")
	@ResponseBody
	public String updateStu(@RequestBody Map map) {
		System.out.println("teacher psw:"+map.get("psw"));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		teacherService.updateTea(map);
		return "";

	}

}
