/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.in.irise.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.in.irise.Entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>{
	
	@Query("from AdminEntity where email = ?1")
	Optional<AdminEntity> findByEmail(String email);

	@Query("from AdminEntity where mobileNo = ?1")
	Optional<AdminEntity> findByMobileNo(String mobileNo);

	@Query("from AdminEntity where id = ?1")
	Optional<AdminEntity> findById(Long id);

	@Query("from AdminEntity where id = ?1")
	void deleteById(Long id);
    
}
