package com.zhengyuan.liunao.entity;

public class Scores {
	private String stuno;
	private String name;
	private String coursename;
	private float score;
	public String type;
	public Scores() {
		super();
	}
	
	
	public Scores(String stuno, String coursename, float score, String type) {
		super();
		this.stuno = stuno;
		this.coursename = coursename;
		this.score = score;
		this.type = type;
	}
	
	
	public Scores(String stuno, String name, String coursename, float score, String type) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.coursename = coursename;
		this.score = score;
		this.type = type;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Scores [stuno=" + stuno + ", name=" + name + ", coursename=" + coursename + ", score=" + score
				+ ", type=" + type + "]";
	}
	
	
	
	
	

}
