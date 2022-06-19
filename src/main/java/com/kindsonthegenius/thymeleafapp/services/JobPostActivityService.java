
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.repositories.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostActivityService {

	@Autowired
	private JobPostActivityRepository jobPostActivityRepository;
	public List<JobPostActivity> getAll() {
		return (List<JobPostActivity>) jobPostActivityRepository.findAll();
	}
	public List<JobPostActivity> getAll(String job, String location, List<String> type, List<String> remote, LocalDate date) {
			return (List<JobPostActivity>) jobPostActivityRepository.search(job,location,remote,type,date);

	}
	public Optional<JobPostActivity> getOne(Integer Id) {
		return jobPostActivityRepository.findById(Id);
	}
	public JobPostActivity addNew(JobPostActivity jobPostActivity) {
		return jobPostActivityRepository.save(jobPostActivity);
	}
	public void update(JobPostActivity jobPostActivity) {
		jobPostActivityRepository.save(jobPostActivity);
	}
	public void delete(Integer Id) {
		jobPostActivityRepository.deleteById(Id);
	}


}
