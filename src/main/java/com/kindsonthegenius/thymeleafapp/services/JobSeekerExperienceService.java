
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerExperience;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerEducationRepository;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerExperienceService {

	@Autowired
	private JobSeekerExperienceRepository jobSeekerExperienceRepository;
	public List<JobSeekerExperience> getAll() {
		return (List<JobSeekerExperience>) jobSeekerExperienceRepository.findAll();
	}
	public Optional<JobSeekerExperience> getOne(Integer Id) {
		return jobSeekerExperienceRepository.findById(Id);
	}
	public void addNew(JobSeekerExperience jobSeekerExperience) {
		System.out.println(("Add New Job Seeker Experience : "));
		System.out.println(jobSeekerExperience.toString());
		jobSeekerExperienceRepository.save(jobSeekerExperience);
	}
	public void update(JobSeekerExperience jobSeekerExperience) {
		jobSeekerExperienceRepository.save(jobSeekerExperience);
	}
	public void delete(Integer Id) {
		jobSeekerExperienceRepository.deleteById(Id);
	}

}
