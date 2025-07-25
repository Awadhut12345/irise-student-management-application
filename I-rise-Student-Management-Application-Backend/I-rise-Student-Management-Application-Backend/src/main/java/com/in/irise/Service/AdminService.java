/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.in.irise.Service;

import com.in.irise.Entity.AdminEntity;

public interface AdminService {
	
	public AdminEntity registerAdminService(AdminEntity admin);
	
	public AdminEntity adminLoginService(String email, String password);
	
	public AdminEntity updateAdmin(Long id, AdminEntity admin);
	
	public String deleteAdminById(Long id);
    
}
