package com.in.irise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in.irise.Entity.StaffEntity;
import com.in.irise.Exception.StaffAccountCreationUnsucessfulException;
import com.in.irise.Service.StaffService;
import com.in.irise.Util.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/StaffRegistration")
public class StaffRegistrationController {
	@Autowired
	private StaffService staffservice;
	@Autowired
	EmailService email;

	@PostMapping("/saveStaff")
	public ResponseEntity<String> staffRegistration( @Valid @RequestBody StaffEntity savestaff) {
		staffservice.createStaff(savestaff);
		email.sendRegistrationEmail(
				savestaff.getEmail(),
				savestaff.getPassword(),
				savestaff.getId()
		        );
		return ResponseEntity.ok("account creation sucessfully");

}
	@PutMapping("/update/{id}")
	public StaffEntity updateStaff(@PathVariable int id,@RequestBody StaffEntity staffentity) {
		 staffservice.updateStaff(id, staffentity);
		 return staffentity;
	}
}