package com.zhengyuan.liunao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhengyuan.liunao.entity.Admin;
import com.zhengyuan.liunao.mapper.AdminMapper;
import com.zhengyuan.liunao.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;

	@Override
	public List<Admin> findAdmin(String account, String psw) {
		// TODO Auto-generated method stub
		return adminMapper.findAdmin(account, psw);
	}

}
