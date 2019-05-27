package com.zhengyuan.liunao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zhengyuan.liunao.entity.Scores;

@Mapper
public interface GcCourseMapper {
	public List<Scores>findScores(String coursename,String type,String gcg,String gcc,int start, int pagesize );
	public List<Scores>findAllScores(String coursename,String type,String gcg,String gcc);
	public List<Scores>compClaScores(String coursename,String gcg);
	public int updateScores(Map map);
	public List<Scores> findPersonScore(String coursename,String num);
}
