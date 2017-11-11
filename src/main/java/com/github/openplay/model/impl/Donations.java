package com.github.openplay.model.impl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.DonationsInterface;

@Component
@XmlRootElement(name="donations")
@Entity
@Table(name="donations")
public class Donations implements DonationsInterface {
	
	@Id
	@GeneratedValue
	private int donationId;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date date;
	
	@NotNull
	private int projects_ProjectId;
	
	@NotNull
	private int users_UserId;
	
	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getProjects_ProjectId() {
		return projects_ProjectId;
	}

	public void setProjects_ProjectId(int projects_ProjectId) {
		this.projects_ProjectId = projects_ProjectId;
	}

	public int getUsers_UserId() {
		return users_UserId;
	}

	public void setUsers_UserId(int users_UserId) {
		this.users_UserId = users_UserId;
	}

}
