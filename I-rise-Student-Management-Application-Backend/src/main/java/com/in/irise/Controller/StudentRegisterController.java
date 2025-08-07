package com.in.irise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.irise.Entity.StudentRegister;
import com.in.irise.Service.StudentRegisterService;
import com.in.irise.util.PasswordGenerator;

@RestController
@RequestMapping("/backend/student")
public class StudentRegisterController {
	
	@Autowired
	private StudentRegisterService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createStudentAccount(@RequestBody StudentRegister student) {
		
		StudentRegister savedStudent = studentService.createAccount(student);
		
		return ResponseEntity.ok("Student register successfully " + savedStudent);
	}
}
