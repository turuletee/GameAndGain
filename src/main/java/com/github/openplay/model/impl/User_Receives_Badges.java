package com.github.openplay.model.impl;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.github.openplay.model.User_Receives_BadgeInterface;
import com.github.openplay.model.UserInterface;
import com.github.openplay.model.BadgeInterface;
import com.github.openplay.model.InterestInterface;




@Component
@Entity
@Table(name="user_receives_badges")
public class User_Receives_Badges implements User_Receives_BadgeInterface, UserInterface,BadgeInterface,InterestInterface{
	@Id
	@GeneratedValue
	private Long idUsers_Receives_Badges;
	
	@NotEmpty
	private int users_UserId;
	
	@NotEmpty
	private int badges_BadgeId;
	
	@NotEmpty
	private int value;

	public Long getIdUsers_Receives_Badges() {
		return idUsers_Receives_Badges;
	}

	public void setIdUsers_Receives_Badges(Long idUsers_Receives_Badges) {
		this.idUsers_Receives_Badges = idUsers_Receives_Badges;
	}

	public int getUsers_UserId() {
		return users_UserId;
	}

	public void setUsers_UserId(int users_UserId) {
		this.users_UserId = users_UserId;
	}

	public int getBadges_BadgeId() {
		return badges_BadgeId;
	}

	public void setBadges_BadgeId(int badges_BadgeId) {
		this.badges_BadgeId = badges_BadgeId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	
	}

	@Override
	public Long getInterestId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInterestId(Long interestId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBadgeId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBadgeId(int badgeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIcon(byte[] icon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserId(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLastname(String lastname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getMail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMail(String mail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getBirthdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBirthdate(Date birthdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCountry(String country) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInterests_InterestId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setInterests_InterestId(int interests_InterestId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRoles_RoleId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRoles_RoleId(int roles_RoleId) {
		// TODO Auto-generated method stub
		
	}
	
	
}
