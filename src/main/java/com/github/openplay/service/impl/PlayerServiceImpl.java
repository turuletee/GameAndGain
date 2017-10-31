package com.github.openplay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.CampaingsHasUsersInterface;
import com.github.openplay.model.impl.CampaignsHasUsers;
import com.github.openplay.repository.CampaignsHasUsersRepository;
import com.github.openplay.service.PlayerService;


@Service("playerService")
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	private CampaignsHasUsersRepository campaignsHasUsersRepository;
	
	@Transactional
	public CampaingsHasUsersInterface save(CampaingsHasUsersInterface campaign) {
		return campaignsHasUsersRepository.save((CampaignsHasUsers) campaign);
	}
	
}
