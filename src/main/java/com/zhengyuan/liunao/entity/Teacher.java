package com.zhengyuan.liunao.entity;

public class Teacher {
	private String teachno;
	private String name;
	private String gra_class;
	private String course;
	private String psw;
	private String sex;
	private String phone;
	private String qq;
	private String photo;
	public Teacher() {
		super();
	}
	public Teacher(String teachno, String name, String gra_class, String course, String psw, String sex, String phone,
			String qq, String photo) {
		super();
		this.teachno = teachno;
		this.name = name;
		this.gra_class = gra_class;
		this.course = course;
		this.psw = psw;
		this.sex = sex;
		this.phone = phone;
		this.qq = qq;
		this.photo = photo;
	}
	public Teacher(String teachno, String name, String sex) {
		super();
		this.teachno = teachno;
		this.name = name;
		this.sex = sex;
	}
	public String getTeachno() {
		return teachno;
	}
	public void setTeachno(String teachno) {
		this.teachno = teachno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGra_class() {
		return gra_class;
	}
	public void setGra_class(String gra_class) {
		this.gra_class = gra_class;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
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
		return "Teacher [teachno=" + teachno + ", name=" + name + ", gra_class=" + gra_class + ", course=" + course
				+ ", psw=" + psw + ", sex=" + sex + ", phone=" + phone + ", qq=" + qq + ", photo=" + photo + "]";
	}
	
}
