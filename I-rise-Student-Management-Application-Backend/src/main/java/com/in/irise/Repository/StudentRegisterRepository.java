package com.in.irise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.irise.Entity.StudentRegister;

public interface StudentRegisterRepository extends JpaRepository<StudentRegister, Integer> {

}
