package com.github.openplay.model;

import java.util.Date;

public interface DonationsInterface {
	
	public int getDonationId();

	public void setDonationId(int donationId);
	
	public Date getDate();

	public void setDate(Date date);

	public int getProjects_ProjectId();

	public void setProjects_ProjectId(int projects_ProjectId);

	public int getUsers_UserId();

	public void setUsers_UserId(int users_UserId);


}
