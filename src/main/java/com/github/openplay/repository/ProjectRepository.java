package com.github.openplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.openplay.model.impl.Project;


@Repository("projectRepository")
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	@Query("select u from Project u where u.name = :nameProject")
	Project findByName(@Param("nameProject") String nameProject);

}
