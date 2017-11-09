package com.github.openplay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.UserInterface;
import com.github.openplay.model.impl.CampaignsHasUsers;
import com.github.openplay.model.impl.Comment;
import com.github.openplay.model.impl.UsersReceivesBadges;
import com.github.openplay.repository.AdminRepository;
import com.github.openplay.repository.RankingRepository;
import com.github.openplay.repository.UsersReceivesBadgesRepository;
import com.github.openplay.service.RankingService;

@Service("rankingService")
public class RankingServiceImpl implements RankingService {
	
	@Autowired
	private RankingRepository rankingRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UsersReceivesBadgesRepository usersReceivesBadgesRepository;
	
	@Transactional
	public List<CampaignsHasUsers> getRanking(String name) {
		
		UserInterface user = adminRepository.findByName(name);
		
		List<CampaignsHasUsers> scores = rankingRepository.findById(user);
		return scores;
	}
	
	@Transactional
	public List<UsersReceivesBadges> getBadge(String name) {
		
		UserInterface user = adminRepository.findByName(name);
		
		int id = user.getUserId();
		
		List<UsersReceivesBadges> badges = usersReceivesBadgesRepository.findById(id);
		return badges;
	}

}

