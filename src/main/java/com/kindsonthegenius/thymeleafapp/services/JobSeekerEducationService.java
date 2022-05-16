
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerEducation;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerEducationRepository;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerSkillSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerEducationService {

	@Autowired
	private JobSeekerEducationRepository jobSeekerEducationRepository;
	public List<JobSeekerEducation> getAll() {
		return (List<JobSeekerEducation>) jobSeekerEducationRepository.findAll();
	}
	public Optional<JobSeekerEducation> getOne(Integer Id) {
		return jobSeekerEducationRepository.findById(Id);
	}
	public void addNew(JobSeekerEducation jobSeekerEducation) {
		System.out.println(("Add New Job Seeker Education: "));
		System.out.println(jobSeekerEducation.toString());
		jobSeekerEducationRepository.save(jobSeekerEducation);
	}
	public void update(JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationRepository.save(jobSeekerEducation);
	}
	public void delete(Integer Id) {
		jobSeekerEducationRepository.deleteById(Id);
	}

}
