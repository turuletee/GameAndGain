package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.openplay.model.PlayerInterface;
import com.github.openplay.model.impl.Player;

public interface PlayerRepository  extends JpaRepository<Player, Long> {
	
	@Query("select s from Player s where s.userName = :userName")
	PlayerInterface findByUserName(@Param("userName") String userName);
	
}
