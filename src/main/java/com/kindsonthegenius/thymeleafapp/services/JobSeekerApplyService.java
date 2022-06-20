
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerApply;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerApplyService {

	@Autowired
	private JobSeekerApplyRepository jobSeekerApplyRepository;
	public List<JobSeekerApply> getAll() {
		return (List<JobSeekerApply>) jobSeekerApplyRepository.findAll();
	}
	public List<JobSeekerApply> getJobCandidates(JobPostActivity job) {
		return (List<JobSeekerApply>) jobSeekerApplyRepository.findByJob(job);
	}
	public Optional<JobSeekerApply> getOne(Integer Id) {
		return jobSeekerApplyRepository.findById(Id);
	}
	public void addNew(JobSeekerApply jobSeekerApply) {
		jobSeekerApplyRepository.save(jobSeekerApply);
	}
	public void update(JobSeekerApply jobSeekerApply) {
		jobSeekerApplyRepository.save(jobSeekerApply);
	}
	public void delete(Integer Id) {
		jobSeekerApplyRepository.deleteById(Id);
	}

}
