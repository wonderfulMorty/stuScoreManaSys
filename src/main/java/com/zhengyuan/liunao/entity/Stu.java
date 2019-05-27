package com.zhengyuan.liunao.entity;

public class Stu {
	private String stuno;
	private String name;
	private String psw;
	private String sex;
	private String phone;
	private String qq;
	private String photo;
	public Stu() {
		super();
	}
	public Stu(String stuno, String name, String psw, String sex, String phone, String qq, String photo) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.psw = psw;
		this.sex = sex;
		this.phone = phone;
		this.qq = qq;
		this.photo = photo;
	}
	public Stu(String stuno, String name, String sex) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.sex = sex;
		
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
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Stu [stuno=" + stuno + ", name=" + name + ", psw=" + psw + ", sex=" + sex + ", phone=" + phone + ", qq="
				+ qq + ", photo=" + photo + "]";
	}
	
	
}
