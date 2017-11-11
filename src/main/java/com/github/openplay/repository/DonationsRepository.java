package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.impl.Donations;

@Repository("donationsRepository")
public interface DonationsRepository extends JpaRepository<Donations, Long> {

}
