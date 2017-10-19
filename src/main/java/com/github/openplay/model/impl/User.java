package com.github.openplay.model.impl;





import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.UserInterface;



@Component
@XmlRootElement(name="users")
@Entity
@Table(name="users")
public class User implements UserInterface{
	
	@Id
	@GeneratedValue
	private Long userId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String lastname;
	
	@NotEmpty
	@Email
	private String mail;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date birthdate;
	
	@NotEmpty
	private int points;
	
	@NotEmpty
	@Size(min=4, max=8)
	private String password;
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private String country;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roleId")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Interest interest;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



}