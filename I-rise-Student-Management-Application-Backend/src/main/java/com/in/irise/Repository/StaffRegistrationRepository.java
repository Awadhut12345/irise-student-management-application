package com.in.irise.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.irise.Entity.StaffEntity;

public interface StaffRegistrationRepository extends JpaRepository<StaffEntity, Integer>{
	boolean existsByEmail(String email);
	boolean existsBymobileNO(String mobileNO);
	Optional<StaffEntity> findById(int id);

}
