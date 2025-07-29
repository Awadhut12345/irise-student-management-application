package com.in.irise.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class StudentRegister {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(max = 10, message = "First name must not exceed 10 characters")
	@NotBlank(message = "First name cannot be blank")
	private String firstName;
	
	@Size(max = 10, message = "Middle name must not exceed 10 characters")
	@NotBlank(message = "Middle name cannot be blank")
	private String middleName;
	
	@Size(max = 10, message = "Last name must not exceed 10 characters")
	@NotBlank(message = "Last name cannot be blank")
	private String lastName;
	
	@NotBlank(message = "Address cannot be blank")
	private String address;
	
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Invalid email format")
	@Column(name = "email", unique = true)
	private String email;
	
	@Pattern(regexp = "\\d{10}", message = "Mobile number must be exactly 10 digits")
	@NotBlank(message = "Mobile number cannot be blank")
	private String mobileNo;
	
	@NotBlank(message = "Password cannot be blank")
	private String password;
	
	@NotBlank(message = "Qualification cannot be blank")
	private String qualification;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", address=" + address + ", email=" + email + ", mobileNo=" + mobileNo + ", password="
				+ password + ", qualification=" + qualification + "]";
	}

}
