
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.repositories.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostActivityService {

	@Autowired
	private JobPostActivityRepository jobPostActivityRepository;
	public List<JobPostActivity> getAll() {
		return (List<JobPostActivity>) jobPostActivityRepository.findAll();
	}
	public Optional<JobPostActivity> getOne(Integer Id) {
		return jobPostActivityRepository.findById(Id);
	}
	public void addNew(JobPostActivity jobPostActivity) {
		System.out.println(("Add New Job Post Skill Set Mapping : "));
		System.out.println(jobPostActivity.toString());
		jobPostActivityRepository.save(jobPostActivity);
	}
	public void update(JobPostActivity jobPostActivity) {
		jobPostActivityRepository.save(jobPostActivity);
	}
	public void delete(Integer Id) {
		jobPostActivityRepository.deleteById(Id);
	}

}
