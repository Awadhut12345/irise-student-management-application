package com.in.irise.Service;



import java.util.Optional;

import com.in.irise.Entity.StaffEntity;

public interface StaffService {
	
	StaffEntity createStaff(StaffEntity create);
	
	StaffEntity updateStaff(int id,StaffEntity update);
	
	Optional<StaffEntity> getById(int id);
	
	Optional<StaffEntity> getByEmail(String email);
	
	void deleteByid(int id);
	
	

}
