package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.impl.ProjectStates;

@Repository("projectStatesRepository")
public interface ProjectStatesRepository extends JpaRepository<ProjectStates, Long> {
	
	@Query("select u from ProjectStates u where u.project_StateId = :id")
	ProjectStates findById(@Param("id") int id);

}
