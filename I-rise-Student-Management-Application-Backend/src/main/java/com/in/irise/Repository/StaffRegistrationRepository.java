package com.in.irise.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.in.irise.Entity.StaffEntity;

public interface StaffRegistrationRepository extends JpaRepository<StaffEntity, Integer>{
	
	  @Query(value = "SELECT * FROM staff_entity WHERE email = :email", nativeQuery = true)
	    Optional<StaffEntity> findByEmail(@Param("email") String email);

	   
	    @Query(value = "SELECT * FROM staff_entity WHERE mobileno = :mobileNo", nativeQuery = true)
	    Optional<StaffEntity> findByMobile(@Param("mobileNo") String mobileNo);
	
	
	Optional<StaffEntity> findById(int id);

}
