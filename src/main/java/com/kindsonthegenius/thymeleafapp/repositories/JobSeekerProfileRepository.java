package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerProfileRepository extends CrudRepository<JobSeekerProfile, Integer> {
  }
