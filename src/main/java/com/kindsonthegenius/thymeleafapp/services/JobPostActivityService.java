
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.*;
import com.kindsonthegenius.thymeleafapp.repositories.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostActivityService {

	@Autowired
	private JobPostActivityRepository jobPostActivityRepository;
	public List<JobPostActivity> getAll() {
		return (List<JobPostActivity>) jobPostActivityRepository.findAll();
	}
	public List<JobPostActivity> search(String job, String location, List<String> type, List<String> remote, LocalDate date) {
			return (List<JobPostActivity>) jobPostActivityRepository.search(job,location,remote,type,date);

	}
	public List<RecruiterJobsClass> getRecruiterJobs(int recruiter) {

		List<RecruiterJobs> recruiterJobs = jobPostActivityRepository.getRecruiterJobs(recruiter);
		List<RecruiterJobsClass> recruiterJobsClasses = new ArrayList<>();
		for(RecruiterJobs rec:recruiterJobs){
			JobLocation loc = new JobLocation(rec.getLocationId(),rec.getCity(),rec.getState(),rec.getCountry());
			JobCompany comp = new JobCompany(rec.getCompanyId(),rec.getName(),"");
			JobPostActivity job = new JobPostActivity();

			recruiterJobsClasses.add(new RecruiterJobsClass(rec.getTotalCandidates(),rec.getJob_post_id(),rec.getJob_title(),loc,comp));
		}
		return recruiterJobsClasses;

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
