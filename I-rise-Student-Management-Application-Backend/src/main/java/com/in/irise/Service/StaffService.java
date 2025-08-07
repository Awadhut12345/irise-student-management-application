package com.in.irise.Service;



import com.in.irise.Entity.StaffEntity;

public interface StaffService {
	
	StaffEntity createStaff(StaffEntity create);
	
	StaffEntity updateStaff(int id,StaffEntity update);
	
	

}
