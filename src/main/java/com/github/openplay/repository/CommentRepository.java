package com.github.openplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.CommentInterface;
import com.github.openplay.model.impl.Comment;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("select c from Comment c where c.users_UserIdTo = :users_userIdTo")
	List<Comment> findUserComment(@Param("users_userIdTo") int users_userIdTo);
	
}

