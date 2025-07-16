package com.soft.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.Admin;
import com.soft.repository.AdminRepository;
import com.soft.service.AdminServiceImpl;


@Service
public class AdminService implements AdminServiceImpl {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin saveAdminService(Admin admin) {
		return adminRepository.save(admin);
	}

}
