package com.github.openplay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.CommentInterface;
import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.model.impl.User;
import com.github.openplay.repository.AdminRepository;
import com.github.openplay.repository.CommentRepository;
import com.github.openplay.service.AdminService;
import com.github.openplay.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements  CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Transactional
	public CommentInterface saveComment(CommentInterface comment) {
		return commentRepository.save((Comment)comment);
	}
	
	@Transactional
	public List<Comment> getComment(int users_UserIdTo) { 
		return commentRepository.findUserComment(users_UserIdTo);
	}

}
