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
@Table(name="users_receives_badges")
public class User_Receives_Badges implements User_Receives_BadgeInterface{
	@Id
	@GeneratedValue
	private int idUsers_Receives_Badges;
	
	@NotEmpty
	private int users_UserId;
	
	@NotEmpty
	private int badges_BadgeId;
	
	@NotEmpty
	private int value;

	public int getIdUsers_Receives_Badges() {
		return idUsers_Receives_Badges;
	}

	public void setIdUsers_Receives_Badges(int idUsers_Receives_Badges) {
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

	
}
