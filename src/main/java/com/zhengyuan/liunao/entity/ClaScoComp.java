package com.zhengyuan.liunao.entity;

public class ClaScoComp {
	public float socre;
	public String cla;
	public ClaScoComp() {
		super();
	}
	public ClaScoComp(float socre, String cla) {
		super();
		this.socre = socre;
		this.cla = cla;
	}
	public float getSocre() {
		return socre;
	}
	public void setSocre(float socre) {
		this.socre = socre;
	}
	public String getCla() {
		return cla;
	}
	public void setCla(String cla) {
		this.cla = cla;
	}
	@Override
	public String toString() {
		return "ClaScoComp [socre=" + socre + ", cla=" + cla + "]";
	}
	
	
}
