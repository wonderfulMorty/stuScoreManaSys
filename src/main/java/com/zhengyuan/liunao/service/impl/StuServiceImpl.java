package com.zhengyuan.liunao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhengyuan.liunao.entity.Scores;
import com.zhengyuan.liunao.entity.Stu;
import com.zhengyuan.liunao.mapper.StuMapper;
import com.zhengyuan.liunao.service.StuService;

@Service
public class StuServiceImpl implements StuService{

	@Autowired
	StuMapper stuMapper;
	
	@Override
	public List<Stu> findStu(String stuno, String psw) {
		// TODO Auto-generated method stub
		return stuMapper.findStu(stuno, psw);
	}

	@Override
	public int addStu(Map map) {
		return stuMapper.addStu(map);
	}
	
	
	@Override
	public List<Stu> findAllStu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return stuMapper.findAllStu(map);
	}

	@Override
	public List<Stu> findStuByName(String name, int start, int pagesize) {
		// TODO Auto-generated method stub
		return stuMapper.findStuByName(name, start, pagesize);
	}

	@Override
	public int stuCount() {
		// TODO Auto-generated method stub
		return stuMapper.stuCount();
	}

	@Override
	public List<Stu> echartStu() {
		// TODO Auto-generated method stub
		return stuMapper.echartStu();
	}

	@Override
	public int deleteByForeach(List<String> stuNO) {
		// TODO Auto-generated method stub
		return stuMapper.deleteByForeach(stuNO);
	}

	@Override
	public int deleteStu(String stuNo) {
		// TODO Auto-generated method stub
		return stuMapper.deleteStu(stuNo);
	}

	@Override
	public List<Stu> getStuByNum(String num) {
		// TODO Auto-generated method stub
		return stuMapper.getStuByNum(num);
	}

	@Override
	public int updateStu(Map map) {
		// TODO Auto-generated method stub
		return stuMapper.updateStu(map);
	}

	@Override
	public List<Stu> findAll() {
		// TODO Auto-generated method stub
		return stuMapper.findAll();
	}

	@Override
	public List<Scores> getScoreByStuName(String name) {
		// TODO Auto-generated method stub
		return stuMapper.getScoreByStuName(name);
	}

}
