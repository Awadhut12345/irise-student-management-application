package com.in.irise.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.irise.Entity.StaffEntity;
import com.in.irise.Exception.StaffAccountCreationUnsucessfulException;
import com.in.irise.Repository.StaffRegistrationRepository;
import com.in.irise.Service.StaffService;
import com.in.irise.Util.StaffRegiPassGenrator;
@Service
public class StaffRegistrationServiceImpl implements StaffService {
	@Autowired
	private	StaffRegistrationRepository staffRepo;
	
	

	@Override
	public StaffEntity createStaff(StaffEntity staff) {
		validateStaff(staff);
			String rawPassword =StaffRegiPassGenrator.generatePassword(10);
			staff.setPassword(rawPassword);
			
			
			return staffRepo.save(staff);
		}

	

	private void validateStaff(StaffEntity staff) {
		if(staffRepo.existsByEmail(staff.getEmail())) {
			throw new StaffAccountCreationUnsucessfulException("EMAIL ALREADY PRESENT");
		}if(staffRepo.existsBymobileNO(staff.getMobileNO())) {
			throw new StaffAccountCreationUnsucessfulException("MOBILE NO ALREADY EXITS");
		}
		
	}



	@Override
	public StaffEntity updateStaff(int id, StaffEntity update) {
		Optional<StaffEntity> updateStaff=staffRepo.findById(id);
		if(updateStaff != null) {
			StaffEntity existsStaff=updateStaff.get();
			if(update.getFullName() != null) {
				existsStaff.setFullName(update.getFullName());
			}
			if(update.getAddress() != null) {
				existsStaff.setAddress(update.getAddress());
			}
			if(update.getExperience()!=null) {
				existsStaff.setExperience(update.getExperience());
			}
			if(update.getQualification() != null) {
				existsStaff.setQualification(update.getQualification());
			}
			if(update.getPinCode() != null) {
				existsStaff.setPinCode(update.getPinCode());	
			}
			if(update.getPreviousOrganization() != null) {
				existsStaff.setPreviousOrganization(update.getPreviousOrganization());
			}
			
			return staffRepo.save(existsStaff);	
			 
		}else {
			throw new StaffAccountCreationUnsucessfulException("UPDATE FAILED");
		}
		
	}
			
			
		}
