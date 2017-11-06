package com.github.openplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.BadgeInterface;
import com.github.openplay.model.CommentInterface;
import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.model.impl.User;
import com.github.openplay.repository.AdminRepository;
import com.github.openplay.repository.BadgeRepository;
import com.github.openplay.repository.CommentRepository;
import com.github.openplay.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements  AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private BadgeRepository badgeRepository;
	
	@Transactional
	public UserInterface save(UserInterface user) {
		return adminRepository.save((User)user);
	}
	
	@Transactional
	public CommentInterface saveComment(CommentInterface comment) {
		return commentRepository.save((Comment)comment);
	}
	
	//public CommentInterface getComment(CommentInterface comment) {
	//	return commentRepository.findById((Comment)comment);
	//}

	public boolean findByLogin(String userName, String password) {	
		UserInterface usr = adminRepository.findByUserName(userName);
		
		if(usr != null && usr.getPassword().equals(password)) {
			return true;
		} 
		
		return false;		
	}

	public boolean findByUserName(String userName) {
		UserInterface usr = adminRepository.findByUserName(userName);
		
		if(usr != null) {
			return true;
		}
		
		return false;
	}
	
	public int findByUserRoleId(String emailAddress) {
		UserInterface usr = adminRepository.findByUserRoleId(emailAddress);
		return usr.getRoles_RoleId();
	}

	@Override
	public BadgeInterface saveBadge(BadgeInterface badge) {
		return badgeRepository.save((Badge)badge);
	}	

}


