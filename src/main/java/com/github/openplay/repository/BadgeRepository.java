package com.github.openplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.BadgeInterface;
import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.Comment;

@Repository("badgeRepository")
public interface BadgeRepository extends JpaRepository<Badge, Long> {
	
	@Query("select b from Badge b") List<Badge> showBadges();

	@Modifying
	@Transactional
	@Query(value="delete from Badge b where b.badgeId = ?1")
	void deleteById(Integer badgeId);
	
}
