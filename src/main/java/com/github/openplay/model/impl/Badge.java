package com.github.openplay.model.impl;

import com.github.openplay.model.BadgeInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;



@Component
@XmlRootElement(name="badges")
@Entity
@Table(name="badges")
public class Badge implements BadgeInterface{
	@Id
	@GeneratedValue
	private int badgeId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private byte[] icon;
	
	@NotEmpty
	private int value;

	public int getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(int badgeId) {
		this.badgeId = badgeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
