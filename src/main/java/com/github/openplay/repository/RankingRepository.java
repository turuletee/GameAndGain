package com.github.openplay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.CampaignsHasUsers;


@Repository("rankingRepository")
public interface RankingRepository extends JpaRepository<CampaignsHasUsers, Long> {
	
	@Query("select c from CampaignsHasUsers c where c.user = :user")
	List<CampaignsHasUsers> findById(@Param("user") UserInterface user);

}
