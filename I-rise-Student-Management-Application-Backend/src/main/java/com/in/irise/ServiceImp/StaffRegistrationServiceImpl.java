package com.in.irise.ServiceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.in.irise.Entity.StaffEntity;
import com.in.irise.Exception.StaffAccountCreationUnsucessfulException;
import com.in.irise.Exception.UserNotFoundException;
import com.in.irise.Repository.StaffRegistrationRepository;
import com.in.irise.Service.StaffService;

@Service
public class StaffRegistrationServiceImpl implements StaffService {
	@Autowired
	private	StaffRegistrationRepository staffRepo;

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



	@Override
	public StaffEntity createStaff(StaffEntity staff) {
		try {
			validateStaff(staff);

			String hashedPassword = passwordEncoder.encode(staff.getPassword());
			staff.setPassword(hashedPassword);
			return staffRepo.save(staff);
		} catch (StaffAccountCreationUnsucessfulException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Something went wrong while creating staff", e);
		}
	}




	private void validateStaff(StaffEntity staff) {
		if (staffRepo.findByEmail(staff.getEmail()).isPresent()) {
			throw new StaffAccountCreationUnsucessfulException("EMAIL ALREADY PRESENT");
		} else if (staffRepo.findByMobile(staff.getMobileNO()).isPresent()) {
			throw new StaffAccountCreationUnsucessfulException("MOBILE NO ALREADY EXISTS");
		}
	}




	@Override
	public StaffEntity updateStaff(int id, StaffEntity update) {
	    try {
	        Optional<StaffEntity> optionalStaff = staffRepo.findById(id);

	        if (optionalStaff.isPresent()) {
	            StaffEntity existingStaff = optionalStaff.get();

	            if (update.getFullName() != null) {
	                existingStaff.setFullName(update.getFullName());
	            }
	            if (update.getAddress() != null) {
	                existingStaff.setAddress(update.getAddress());
	            }
	            if (update.getExperience() != null) {
	                existingStaff.setExperience(update.getExperience());
	            }
	            if (update.getQualification() != null) {
	                existingStaff.setQualification(update.getQualification());
	            }
	            if (update.getPinCode() != null) {
	                existingStaff.setPinCode(update.getPinCode());
	            }
	            if (update.getPreviousOrganization() != null) {
	                existingStaff.setPreviousOrganization(update.getPreviousOrganization());
	            }
	            if (update.getPassword() != null) {
	                String encodedPassword = passwordEncoder.encode(update.getPassword());
	                existingStaff.setPassword(encodedPassword);
	            }
	            if (update.getMobileNO() != null) {
	                existingStaff.setMobileNO(update.getMobileNO());
	            }

	            return staffRepo.save(existingStaff);

	        } else {
	            throw new StaffAccountCreationUnsucessfulException("Staff ID not found for update");
	        }
	    } catch (StaffAccountCreationUnsucessfulException e) {
	        throw e;
	    } catch (Exception e) {
	        throw new RuntimeException("An error occurred while updating staff", e);
	    }
	}





	@Override
	public Optional<StaffEntity> getById(int id) {
	    try {
	        Optional<StaffEntity> result = staffRepo.findById(id);
	        if (result.isEmpty()) {
	            throw new UserNotFoundException("USER NOT FOUND: " + id);
	        }
	        return result;
	    } catch (Exception e) {
	        throw new RuntimeException("Error retrieving user with ID: " + id, e);
	    }
	}

	

	@Override
	public Optional<StaffEntity> getByEmail(String email) {
	    try {
	        Optional<StaffEntity> getUser = staffRepo.findByEmail(email);

	        if (getUser.isEmpty()) {
	            throw new UserNotFoundException("USER NOT FOUND: " + email);
	        }

	        return getUser;

	    } catch (Exception e) {
	        throw new RuntimeException("Error retrieving user with email: " + email, e);
	    }
	}



	@Override
	public void deleteByid(int id) {
		 try {
			 StaffEntity getUser = staffRepo.getById(id);
		        if (getUser == null) {
		            throw new UserNotFoundException("USER NOT FOUND: " + id);
		        }else {
		        	staffRepo.deleteById(id);
		        }
		        
		    } catch (Exception e) {
		        throw new RuntimeException("USER NOT DELETED " + e);
		    }
		
	}


}
