package com.zhengyuan.liunao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zhengyuan.liunao.entity.Scores;
import com.zhengyuan.liunao.entity.Stu;

@Mapper
public interface StuMapper {
	public List<Stu> findStu(String stuno, String psw);
	public int addStu(Map map);
	
	
	public List<Stu> findAllStu(Map<String, Object> map);

	public List<Stu> findAll();

	public List<Stu> findStuByName(String name, int start, int pagesize);

	public int stuCount();

	public List<Stu> echartStu();

	public int deleteByForeach(List<String> stuno);

	public int deleteStu(String stuno);

	public List<Stu> getStuByNum(String stuno);

	public int updateStu(Map map);
	
	public List<Scores> getScoreByStuName(String name);
	
	
}
