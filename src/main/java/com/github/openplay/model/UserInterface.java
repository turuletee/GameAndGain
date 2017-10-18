package com.github.openplay.model;

import java.util.Date;

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
	
	public int getInterests_InterestId();
	
	public void setInterests_InterestId(int interests_InterestId);
	
	public int getRoles_RoleId();
	
	public void setRoles_RoleId(int roles_RoleId);
	
	
	
	
}
