
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobPostSkillSetMapping;
import com.kindsonthegenius.thymeleafapp.repositories.JobPostSkillSetMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostSkillSetMappingService {

	@Autowired
	private JobPostSkillSetMappingRepository jobPostSkillSetMappingRepository;
	public List<JobPostSkillSetMapping> getAll() {
		return (List<JobPostSkillSetMapping>) jobPostSkillSetMappingRepository.findAll();
	}
	public Optional<JobPostSkillSetMapping> getOne(Integer Id) {
		return jobPostSkillSetMappingRepository.findById(Id);
	}
	public void addNew(JobPostSkillSetMapping jobPostSkillSetMapping) {
		System.out.println(("Add New Job Post Skill Set Mapping : "));
		System.out.println(jobPostSkillSetMapping.toString());
		jobPostSkillSetMappingRepository.save(jobPostSkillSetMapping);
	}
	public void update(JobPostSkillSetMapping jobTypeMaster) {
		jobPostSkillSetMappingRepository.save(jobTypeMaster);
	}
	public void delete(Integer Id) {
		jobPostSkillSetMappingRepository.deleteById(Id);
	}

}
