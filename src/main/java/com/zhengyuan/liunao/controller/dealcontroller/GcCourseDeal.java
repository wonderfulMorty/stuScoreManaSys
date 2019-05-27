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
import com.zhengyuan.liunao.entity.ClaScoComp;
import com.zhengyuan.liunao.entity.Scores;
import com.zhengyuan.liunao.entity.Teacher;
import com.zhengyuan.liunao.service.GcCourseService;
import com.zhengyuan.liunao.tools.CountTool;
import com.zhengyuan.liunao.tools.Layui;

@Controller
@RequestMapping("/Sys")
public class GcCourseDeal {

	@Autowired
	GcCourseService gcCourseService;
	
	
	@RequestMapping("/getGcs")
	@ResponseBody
	public String findAllScores(@RequestParam("key[coursename]")String coursename,@RequestParam("key[type]") String type,
			@RequestParam("key[grade]")String gcg,@RequestParam("key[cla]")String gcc,@RequestParam("limit") String limit, @RequestParam("page") String page) {
		int lim = Integer.parseInt(limit);
		int start = (Integer.parseInt(page) - 1) * lim;
		List<Scores> data = new ArrayList<>();
		List<Scores> data2 = new ArrayList<>();
		data =  gcCourseService.findScores(coursename, type,gcg, gcc, start,lim);
		data2 = gcCourseService.findAllScores(coursename, type, gcg, gcc);
		int total = data2.size();
		Layui l = Layui.data(total, data);
		return JSON.toJSONString(l);
	}
	
	@RequestMapping("/getGcsCount")
	@ResponseBody
	public String getGcsCount(@RequestParam("coursename")String coursename,@RequestParam("type") String type,
			@RequestParam("grade")String gcg,@RequestParam("cla")String gcc) {
		
		List<Scores> data = new ArrayList<>();
		data =  gcCourseService.findAllScores(coursename, type, gcg, gcc);
	    List<Map> list = new ArrayList<>();
		Map map1 = new HashMap<>();
		Map map2 = new HashMap<>();
		Map map3 = new HashMap<>();
		Map map4 = new HashMap<>();
		Map map5 = new HashMap<>();
		int n1=0;
		int n2=0;
		int n3=0;
		int n4=0;
		int n5=0;
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getScore()>=90) {
				n1++;
				map1.put("quality", "优");
				map1.put("count", n1);
			}else if(data.get(i).getScore()>=80&&data.get(i).getScore()<90) {
				n2++;
				map2.put("quality", "良");
				map2.put("count", n2);
			}else if(data.get(i).getScore()>=70&&data.get(i).getScore()<80) {
				n3++;
				map3.put("quality", "一般");
				map3.put("count", n3);
			}else if(data.get(i).getScore()>=60&&data.get(i).getScore()<70) {
				n4++;
				map4.put("quality", "较差");
				map4.put("count", n4);
			}else if(data.get(i).getScore()<60) {
				n5++;
				map5.put("quality", "不及格");
				map5.put("count", n5);
			}
		}
		
	    if(n1!=0) {
	    	list.add(map1);
	    }
	    if(n2!=0) {
	    	list.add(map2);
	    }
	    if(n3!=0) {
	    	list.add(map3);
	    }
	    if(n4!=0) {
	    	list.add(map4);
	    }
	    if(n5!=0) {
	    	list.add(map5);
	    }
	    
		
		String jsonString = JSON.toJSONString(list);

		
		/*
		List<Integer>mydata = new ArrayList<>();
		for(int i=1;i<9;i++) {
			mydata.add(i);
		}
		String jsonString2 = JSON.toJSONString(mydata);
		System.out.println(jsonString2);*/
		
		return jsonString;
	}
	
	
	@RequestMapping("/getGscomp")
	@ResponseBody
	public String getGscomp(@RequestParam("coursename")String coursename,@RequestParam("grade")String gcg) {
		List<Scores> data = new ArrayList<>();
		data = gcCourseService.compClaScores(coursename, gcg);
		
		List<Float>sc1 = new ArrayList<>();
		List<Float>sc2 = new ArrayList<>();
		List<Float>sc3 = new ArrayList<>();
		
		float sum1=0;
		float sum2=0;
		float sum3=0;
		
		
		for(int i=0;i<data.size();i++) {
			if(data.get(i).getStuno().substring(4, 6).equals("01")) {
				sc1.add(data.get(i).getScore());
				sum1=sum1+data.get(i).getScore();
			}else if(data.get(i).getStuno().substring(4, 6).equals("02")) {
				sc2.add(data.get(i).getScore());
				sum2=sum2+data.get(i).getScore();
			}if(data.get(i).getStuno().substring(4, 6).equals("03")) {
				sc3.add(data.get(i).getScore());
				sum3=sum3+data.get(i).getScore();
			}
		}
		
		float sav1 = CountTool.aveNums(sum1, sc1.size());
	    float sma1 = CountTool.maxNum(sc1);
	    float smd1 = CountTool.midnum(sc1);
	    
	    float sav2 = CountTool.aveNums(sum2, sc2.size());
	    float sma2 = CountTool.maxNum(sc2);
	    float smd2 = CountTool.midnum(sc2);
	    
	    float sav3 = CountTool.aveNums(sum3, sc3.size());
	    float sma3 = CountTool.maxNum(sc3);
	    float smd3 = CountTool.midnum(sc3);
	    
	    
	    float[][] scores = new float[3][3];
	    scores[0][0] = sav1;
	    scores[0][1] = sav2;
	    scores[0][2] = sav3;
	    
	    scores[1][0] = sma1;
	    scores[1][1] = sma2;
	    scores[1][2] = sma3;
	    
	    scores[2][0] = smd1;
	    scores[2][1] = smd2;
	    scores[2][2] = smd3;
	    
	    
	    String jsonString = JSON.toJSONString(scores);
	    System.out.println(jsonString);
		return jsonString;
	}
	
	
	
	
	@RequestMapping("/getPersonScore")
	@ResponseBody
	public String getPersonScore(@RequestParam("coursename") String coursename,@RequestParam("num") String num) {
		List<Scores> scoreList = new ArrayList<>();
		scoreList =gcCourseService.findPersonScore(coursename, num);
		int total = scoreList.size();
		Layui l = Layui.data(total, scoreList);
		System.out.println(JSON.toJSONString(l));
		return JSON.toJSONString(l);

	}
	
	
	@RequestMapping("/updateClaCou")
	@ResponseBody
	public String updateClaCou(@RequestBody Map map) {
		if(map.get("type").toString().equals("未批改")) {
			map.put("score",0);
		}
		int n = gcCourseService.updateScores(map);
		if(n>0) {
			return "success";
		}
		return "fail";

	}
	
	
	
	
}
