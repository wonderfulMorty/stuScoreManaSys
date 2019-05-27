package com.zhengyuan.liunao.controller.dealcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zhengyuan.liunao.entity.Scores;
import com.zhengyuan.liunao.entity.Stu;
import com.zhengyuan.liunao.service.StuService;
import com.zhengyuan.liunao.tools.Layui;

import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/Sys")
@Api("StuInfoDeal相关api")
@Slf4j
public class StuInfoDeal {
	@Autowired
	StuService stuService;

	
	@RequestMapping(value = "/getStuInfo")
	@ResponseBody
	public Object getStuInfo(@RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("pagesize", lim);
		List<Stu> allStu = stuService.findAllStu(map);
		int total = stuService.stuCount();
		
		Layui l = Layui.data(total, allStu);
		return JSON.toJSON(l);
	}

	
	@RequestMapping(value = "/getStuSimpleInfo")
	@ResponseBody
	public Object getStuSimpleInfo(@RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("pagesize", lim);
		List<Stu> allStu = stuService.findAllStu(map);
		List<Stu> stu = new ArrayList<>();
		for(int i = 0;i<allStu.size();i++) {
			String stuno = allStu.get(i).getStuno();
			String name = allStu.get(i).getName();
			String sex = allStu.get(i).getSex();
			stu.add(new Stu(stuno,name,sex));
		}
		int total = stuService.stuCount();
		System.out.println(total);
		Layui l = Layui.data(total, stu);
		return JSON.toJSON(l);
	}

	
	
	
	
	
	@ApiOperation("获取学生的信息")
	
	@ApiResponses({ @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })

	@RequestMapping("/getStuByName")
	@ResponseBody
	public String getStuByName(@RequestParam("key[id]") String name, @RequestParam("limit") String limit,
			@RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		if (name.equals("")) {
			Map<String, Object> map = new HashMap<>();
			map.put("start", start);
			map.put("pagesize", lim);
			List<Stu> stuList = stuService.findAllStu(map);
			int total = stuService.stuCount();
			Layui l = Layui.data(total, stuList);
			return JSON.toJSONString(l);
		} else {
			List<Stu> stuList = stuService.findStuByName(name, start, lim);
			int total = stuList.size();
			Layui l = Layui.data(total, stuList);
			System.out.println("学生信息："+JSON.toJSONString(l));
			return JSON.toJSONString(l);
		}
	}

	@RequestMapping("/deleteStus")
	@ResponseBody
	public String deleteStus(@RequestParam("nums") Object nums) {
		String datas = nums.toString();
		System.out.println(datas);
		String[] str = datas.split(",");
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			data.add(str[i]);
		}

		System.out.println(data.toString());
		if (stuService.deleteByForeach(data) > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("/deleteStu")
	@ResponseBody
	public String deleteStu(@RequestParam("num") String num) {
		if (stuService.deleteStu(num) > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("/getStuByNum")
	@ResponseBody
	public String getStuByNum(@RequestParam("num") Object num) {
		String stuNo = num.toString();
		List<Stu> stuList = new ArrayList<>();
		stuList = stuService.getStuByNum(stuNo);
		int total = stuList.size();
		Layui l = Layui.data(total, stuList);
		System.out.println(num);
		System.out.println("getStuByNum---->" + JSON.toJSONString(l));
		return JSON.toJSONString(l);
	}

	@RequestMapping("/updateStu")
	@ResponseBody
	public String updateStu(@RequestBody Map map) {
		System.out.println("stu psw:"+map.get("psw"));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		stuService.updateStu(map);
		return "success";

	}

	@RequestMapping("/getScoreByStuName")
	@ResponseBody
	public String getScoreByStuName(HttpSession httpSession) {
		String name = (String) httpSession.getAttribute("name");
		List<Scores> scoreList = new ArrayList<>();
		List<Scores> datas = new ArrayList<>();
		scoreList = stuService.getScoreByStuName(name);
		for(int i=0;i<scoreList.size();i++) {
			if(scoreList.get(i).getType().equals("已批改")) {
				datas.add(scoreList.get(i));
			}
		}
		
		Layui l = Layui.data(datas.size(), datas);
		return JSON.toJSONString(l);

	}

}
