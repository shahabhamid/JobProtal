package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.JobPostSkillSetMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostSkillSetMappingRepository extends CrudRepository<JobPostSkillSetMapping, Integer> {

}
