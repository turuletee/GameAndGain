package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.User;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.mail = :userName")
	UserInterface findByUserName(@Param("userName") String userName);
	
}
