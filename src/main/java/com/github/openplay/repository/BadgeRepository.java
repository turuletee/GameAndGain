package com.github.openplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.BadgeInterface;
import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.Comment;

@Repository("badgeRepository")
public interface BadgeRepository extends JpaRepository<Badge, Long> {
	
	@Query("select b from Badge b") List<Badge> showBadges();
	
}
