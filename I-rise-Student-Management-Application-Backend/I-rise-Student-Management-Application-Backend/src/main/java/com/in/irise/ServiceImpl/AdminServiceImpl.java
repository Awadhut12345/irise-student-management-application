/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.in.irise.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.in.irise.Entity.AdminEntity;
import com.in.irise.Repository.AdminRepository;
import com.in.irise.Service.AdminService;
import com.in.irise.Util.EmailUtil;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminEntity registerAdminService(AdminEntity admin) 
	{
	    try 
	    {
	        Optional<AdminEntity> existingEmail = adminRepository.findByEmail(admin.getEmail());
	        
	        if (existingEmail.isPresent()) 
	        {
	            throw new RuntimeException("Email already exists");
	        }

	        if (admin.getMobileNo() != null) 
	        {
	            Optional<AdminEntity> existingMobile = adminRepository.findByMobileNo(admin.getMobileNo());
	            
	            if (existingMobile.isPresent()) 
	            {
	                throw new RuntimeException("Mobile number already exists");
	            }
	        }

	        String encodedPassword = passwordEncoder.encode(admin.getPassword());
	        admin.setPassword(encodedPassword);

	        return adminRepository.save(admin);
	    } 
	    catch (Exception e) 
	    {
	        throw new RuntimeException("Registration failed: " + e.getMessage());
	    }
	}
	
	@Override
	public AdminEntity adminLoginService(String email, String password) 
	{
	    try 
	    {
	        Optional<AdminEntity> optionalAdmin = adminRepository.findByEmail(email);

	        if (!optionalAdmin.isPresent()) 
	        {
	            throw new RuntimeException("Admin not found with email: " + email);
	        }

	        AdminEntity admin = optionalAdmin.get();

	        if (!passwordEncoder.matches(password, admin.getPassword())) 
	        {
	            throw new RuntimeException("Invalid password");
	        }

	        return admin;  
	    } 
	    catch (Exception e) 
	    {
	        throw new RuntimeException("Login failed: " + e.getMessage());
	    }
	}
	
	@Override
	public AdminEntity updateAdmin(Long id, AdminEntity admin) 
	{
	    try {
	        AdminEntity existingAdmin = adminRepository.findById(id).orElse(null);

	        if (existingAdmin == null) 
	        {
	            throw new RuntimeException("Admin not found with ID: " + id);
	        }

	        existingAdmin.setFirstName(admin.getFirstName());
	        existingAdmin.setLastName(admin.getLastName());
	        existingAdmin.setAddress(admin.getAddress());
	        existingAdmin.setPincode(admin.getPincode());
	        existingAdmin.setMobileNo(admin.getMobileNo());
	        existingAdmin.setEmail(admin.getEmail());
	        existingAdmin.setPassword(passwordEncoder.encode(admin.getPassword()));

	        return adminRepository.save(existingAdmin);
	        
	    } 
	    catch (Exception e) 
	    {
	        throw new RuntimeException("Unexpected error during update: " + e.getMessage());
	    }
	}
	   
	@Override
	public String deleteAdminById(Long id) 
	{
	    try 
	    {
	        if (adminRepository.existsById(id)) 
	        {
	            adminRepository.deleteById(id);
	            
	            return "Admin deleted successfully with ID: " + id;
	        } 
	        else 
	        {
	            throw new RuntimeException("Admin not found with ID: " + id);
	        }
	    } 
	    catch (Exception e) 
	    {
	        throw new RuntimeException("Unexpected error during delete: " + e.getMessage());
	    } 
	}
   
}
