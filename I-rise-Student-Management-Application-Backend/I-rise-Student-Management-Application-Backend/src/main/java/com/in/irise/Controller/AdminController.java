/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.in.irise.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.irise.Entity.AdminEntity;
import com.in.irise.Service.AdminService;
import com.in.irise.Util.EmailUtil;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/v1")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@GetMapping("/welcome")
	public String WelcomeAdmin()
	{
		return "Welcome to Irise Student Management";
	}
	
	 @PostMapping("/registerAdmin")
	 public ResponseEntity<HashMap<String, Object>> registerAdmin(@Valid @RequestBody AdminEntity admin) 
	 {
	        HashMap<String, Object> response = new HashMap<>();

	        try 
	        {
	            String rawPassword = admin.getPassword();

	            AdminEntity savedAdmin = adminService.registerAdminService(admin);

	            String message = new StringBuilder()
	                    .append("Hello Admin, ")
	                    .append(savedAdmin.getFirstName())
	                    .append(", Your Password is: ")
	                    .append(rawPassword)
	                    .toString();

	            emailUtil.send2(savedAdmin.getEmail(), "Welcome to Admin!", message);

	            response.put("status", "201");
	            response.put("message", "Admin registered successfully");
	            response.put("admin", savedAdmin);

	            return ResponseEntity.status(HttpStatus.CREATED).body(response);
	        } 
	        catch (RuntimeException e) 
	        {
	        	response.put("status", "400");
	            response.put("message", "Registration failed: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	        } 
	        catch (Exception ex) 
	        {
	        	response.put("status", "500");
	            response.put("error", "Something went wrong: " + ex.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }
    
	@PostMapping("/loginAdmin")
	public ResponseEntity<HashMap<String, Object>> loginAdmin(@RequestParam String email, @RequestParam String password) 
	{
	    HashMap<String, Object> response = new HashMap<>();

	    try 
	    {
	        AdminEntity adminLogin = adminService.adminLoginService(email, password);

	        response.put("status", "200");
	        response.put("message", "Login successful");
	        response.put("data", adminLogin);

	    } 
	    catch (RuntimeException e) 
	    {
	        response.put("status", e.getMessage());
	        response.put("message", "Invalid credentials");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	    return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<HashMap<String, Object>> updateAdmin(@RequestParam Long id, @RequestBody AdminEntity updatedAdmin) 
	{
	    HashMap<String, Object> response = new HashMap<>();

	    try 
	    {
	        AdminEntity updated = adminService.updateAdmin(id, updatedAdmin);

	        response.put("status", "200");
	        response.put("message", "Admin updated successfully");
	        response.put("admin", updated);

	        return ResponseEntity.ok(response);
	    } 
	    catch (Exception e) 
	    {
	        response.put("status", "404");
	        response.put("error", "Update failed: " + e.getMessage());
	        
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    } 
	}
	
	@DeleteMapping("/deleteAdmin")
	public ResponseEntity<HashMap<String, Object>> deleteAdmin(@RequestParam Long id) 
	{
	    HashMap<String, Object> response = new HashMap<>();

	    try 
	    {
	        String message = adminService.deleteAdminById(id);

	        response.put("status", "200");
	        response.put("message", message);

	        return ResponseEntity.ok(response);
	    } 
	    catch (RuntimeException e) 
	    {
	        response.put("status", "404");
	        response.put("error", "Admin not found: " + e.getMessage());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    } 
	}

}
