package com.zhengyuan.liunao.entity;

public class Admin {
	private String account;
	private String psw;
	private String name;
	public Admin() {
		super();
	}
	public Admin(String account, String psw, String name) {
		super();
		this.account = account;
		this.psw = psw;
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Admin [account=" + account + ", psw=" + psw + ", name=" + name + "]";
	}
	
	

}
