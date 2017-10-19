package com.github.openplay.model;



public interface BadgeInterface {
	
	public int getBadgeId();
	
	public void setBadgeId(int badgeId);
	
	public String getName();
	
	public void setName(String name);
	
	public byte[] getIcon();
	
	public void setIcon(byte[] icon);
	
	public int getValue();
	
	public void setValue(int value);
	
}