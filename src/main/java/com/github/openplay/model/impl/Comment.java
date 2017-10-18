package com.github.openplay.model.impl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.github.openplay.model.CommentInterface;

@Component
@XmlRootElement(name="comment")
@Entity
@Table(name="comments")
public class Comment implements CommentInterface {
	
	@Id
	@GeneratedValue
	private int commentId;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date date;
	
	@NotEmpty
	@Size(min=4, max=500)
	private String comment;
	
	@NotNull
	private int users_UserIdFrom;
	
	@NotNull
	private int users_UserIdTo;
	
	//private User users;
	
	public void createComment(int userIdFrom, int userIdTo, Date date, String comment) {
		/*
		this.Users_UserIdFrom = users.getUser(userIdFrom);
		this.Users_UserIdTo = users.getUser(userIdTo);
		this.Date = date;
		this.Comment = comment;
		*/
	}

	public String getComment() {
		return comment;
	}

}