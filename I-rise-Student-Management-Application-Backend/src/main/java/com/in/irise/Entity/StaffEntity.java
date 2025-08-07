package com.in.irise.Entity;


import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class StaffEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "fullName", nullable = false, length = 50)
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Name can only contain letters and spaces")
	private String fullName;

	@NotNull
	private String address;

	@NotNull
	private Long pinCode;

	@Column(length =10,nullable = false)
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be 10 digits and start with 6-9")
	private String mobileNO;

	@Email(message = "Invalid email format")
	@Column(nullable = false, unique = true)
	private String email;

	@NotNull
	private String qualification;

	@NotNull
	private String experience;

	@NotNull
	private String previousOrganization;

	@Column(nullable = false)
	private String password;

	private Date dateOfJoining;
	
	private LocalDateTime dateOfAccCreation;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	public String  getMobileNO() {
		return mobileNO;
	}
	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getPreviousOrganization() {
		return previousOrganization;
	}
	public void setPreviousOrganization(String previousOrganization) {
		this.previousOrganization = previousOrganization;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	 @CreatedDate 
	public LocalDateTime getDateOfAccCreation() {
		return dateOfAccCreation;
	}
	public void setDateOfAccCreation(LocalDateTime dateOfAccCreation) {
		this.dateOfAccCreation = dateOfAccCreation;
	}
	public StaffEntity() {
		super();

	}



}
