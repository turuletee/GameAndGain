package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.impl.Badge;
import com.github.openplay.model.impl.Comment;

@Repository("badgeRepository")
public interface BadgeRepository extends JpaRepository<Badge, Long> {

}
