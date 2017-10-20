package com.github.openplay.model.impl;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@NotNull
	@Size(min=1, max=500)
	private String comment;
	
	@NotNull
	private int users_UserIdFrom;
	
	@NotNull
	private int users_UserIdTo;
	
	
	//To get the user id from the user who sent the comment 
	@ManyToOne
	@NotNull
	@JoinColumn(name = "users_UserIdFrom", insertable = false, updatable = false)
	private User userfrom;
	

	//To get the user id of receiver
	@ManyToOne
	@JoinColumn(name = "users_UserIdTo", insertable = false, updatable = false)
	@NotNull
	private User userto;
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getUsers_UserIdFrom() {
		return users_UserIdFrom;
	}

	public void setUsers_UserIdFrom1(int users_UserIdFrom) {
		this.users_UserIdFrom = users_UserIdFrom;
	}

	public int getUsers_UserIdTo() {
		return users_UserIdTo;
	}

	public void setUsers_UserIdTo1(int users_UserIdTo) {
		this.users_UserIdTo = users_UserIdTo;
	}

	public User getUserfrom() {
		return userfrom;
	}

	public void setUserfrom(User userfrom) {
		this.userfrom = userfrom;
	}

	public User getUserto() {
		return userto;
	}

	public void setUserto(User userto) {
		this.userto = userto;
	}

	@Override
	public void setUsers_UserIdFrom(int users_UserIdFrom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUsers_UserIdTo(int users_UserIdTo) {
		// TODO Auto-generated method stub
		
	}
	
}