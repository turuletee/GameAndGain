package com.github.openplay.service.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.openplay.model.impl.Campaign;
import com.github.openplay.service.CampaignService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CampaignServiceImpl implements CampaignService {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public void createCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		entityManager.persist(campaign);
	}

	@Override
	public Campaign getCampaign(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Campaign.class, id);
	}

	@Override
	public List<Campaign> getAllCampaigns() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select * from Campaign").getResultList();
	}

	@Override
	public void editCampaign(Campaign campaign) {
		entityManager.merge(campaign);

	}

	@Override
	public void deleteCampaign(int id) {
		Campaign c = entityManager.find(Campaign.class, id);
		entityManager.remove(c);

	}

}
