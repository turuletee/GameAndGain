package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.impl.CampaignsHasUsers;

@Repository("campaignsHasUserRepository")
public interface CampaignsHasUsersRepository extends JpaRepository<CampaignsHasUsers, Integer> {

}
