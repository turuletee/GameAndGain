package com.github.openplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.CampaignsHasUsers;
import com.github.openplay.model.impl.UsersReceivesBadges;

@Repository("usersReceivesBadgesRepository")
public interface UsersReceivesBadgesRepository extends JpaRepository<UsersReceivesBadges, Long> {
	
	@Query("select c from UsersReceivesBadges c where c.users_UserId = :id")
	List<UsersReceivesBadges> findById(@Param("id") int id);

}
