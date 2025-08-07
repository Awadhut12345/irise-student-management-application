package com.in.irise.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.irise.Entity.StudentRegister;
import com.in.irise.Repository.StudentRegisterRepository;
import com.in.irise.Service.StudentRegisterService;
import com.in.irise.util.PasswordGenerator;

@Service
public class StudentRegisterServiceImp implements StudentRegisterService{
	
	@Autowired
	private StudentRegisterRepository studentRepository;

	@Override
	public StudentRegister createAccount(StudentRegister student) {
		student.setPassword(PasswordGenerator.generatePassword());
	    
		return studentRepository.save(student);
	}
}
