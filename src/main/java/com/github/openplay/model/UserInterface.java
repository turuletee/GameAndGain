package com.github.openplay.model;

import java.util.Date;

import com.github.openplay.model.impl.Interest;
import com.github.openplay.model.impl.Role;

public interface UserInterface {
	public Long getUserId();
	
	public void setUserId(Long userId);
	
	public String getName();
	
	public void setName(String name);
	
	public String getLastname();
	
	public void setLastname(String lastname);
	
	public String getMail();
	
	public void setMail(String mail);
	
	public Date getBirthdate();
	
	public void setBirthdate(Date birthdate);
	
	public int getPoints();
	
	public void setPoints(int points);
	
	public String getPassword();
	
	public void setPassword(String password);
	
	public String getPhone();
	
	public void setPhone(String phone);
	
	public String getCountry();
	
	public void setCountry(String country);
	
	public Interest getInterest();
	
	public void setInterest(Interest interest);
	
	public Role getRole();
	
	public void setRole(Role role);
	
}
