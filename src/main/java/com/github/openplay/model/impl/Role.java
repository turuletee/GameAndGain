package com.github.openplay.model.impl;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.github.openplay.model.RoleInterface;

@Component
@XmlRootElement(name="roles")
@Entity
@Table(name="roles")
public class Role implements RoleInterface{
	@Id
	@GeneratedValue
	private Long roleId;
	
	@NotEmpty
	private String description;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}