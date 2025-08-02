package com.in.irise.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.in.irise.Entity.StaffEntity;
import com.in.irise.Service.StaffService;
import com.in.irise.util.StaffEmail;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/StaffRegistration/v1")
public class StaffRegistrationController {

    @Autowired
    private StaffService staffservice;
 @Autowired
 StaffEmail email;
    
    @PostMapping("/saveStaff")
    public ResponseEntity<Map<String, Object>> staffRegistration(@Valid @RequestBody StaffEntity staff) {
        Map<String, Object> response = new HashMap<>();
        try {
        	
            StaffEntity savedStaff = staffservice.createStaff(staff);
            email.sendRegistrationEmail(
            		staff.getEmail(),
            		staff.getPassword(),
            		staff.getId()
    		        );
            
            response.put("status", "success");
            response.put("message", "Staff registered successfully");
            response.put("data", savedStaff);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Registration failed: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

   
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateStaff(@PathVariable int id, @RequestBody StaffEntity staffEntity) {
        Map<String, Object> response = new HashMap<>();
        try {
            StaffEntity updated = staffservice.updateStaff(id, staffEntity);
            response.put("status", "success");
            response.put("message", "Staff updated successfully");
            response.put("data", updated);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Update failed: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<StaffEntity> staff = staffservice.getById(id);
            response.put("status", "success");
            response.put("message", "Staff found");
            response.put("data", staff);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "User not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

   
    @GetMapping("/email/{email}")
    public ResponseEntity<Map<String, Object>> getByEmail(@PathVariable String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            Optional<StaffEntity> staff = staffservice.getByEmail(email);
            response.put("status", "success");
            response.put("message", "Staff found");
            response.put("data", staff);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "User not found: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            staffservice.deleteByid(id);
            response.put("status", "success");
            response.put("message", "Staff deleted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Delete failed: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
