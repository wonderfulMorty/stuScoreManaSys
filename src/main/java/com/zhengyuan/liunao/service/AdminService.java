package com.zhengyuan.liunao.service;

import java.util.List;

import com.zhengyuan.liunao.entity.Admin;

public interface AdminService {
	public List<Admin> findAdmin(String account, String psw);
}
