package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerProfileService {

	@Autowired
	private JobSeekerProfileRepository jobSeekerProfileRepository;
	public List<JobSeekerProfile> getAll() {
		return (List<JobSeekerProfile>) jobSeekerProfileRepository.findAll();
	}
	public Optional<JobSeekerProfile> getOne(Integer Id) {
		return jobSeekerProfileRepository.findById(Id);
	}
	public void addNew(JobSeekerProfile jobSeekerProfile) {
		System.out.println(("Add New Job Seeker Profile : "));
		System.out.println(jobSeekerProfile.toString());
		jobSeekerProfileRepository.save(jobSeekerProfile);
	}
	public void update(JobSeekerProfile jobSeekerProfile) {
		jobSeekerProfileRepository.save(jobSeekerProfile);
	}
	public void delete(Integer Id) {
		jobSeekerProfileRepository.deleteById(Id);
	}

}
