
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobPostActivity;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.JobSeekerSave;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerSaveService {

	@Autowired
	private JobSeekerSaveRepository jobSeekerSaveRepository;
	public List<JobSeekerSave> getAll() {
		return (List<JobSeekerSave>) jobSeekerSaveRepository.findAll();
	}
	public List<JobSeekerSave> getJobCandidates(JobPostActivity job) {
		return (List<JobSeekerSave>) jobSeekerSaveRepository.findByJob(job);
	}
	public List<JobSeekerSave> getCandidatesJobs(JobSeekerProfile user_account_id){
		return (List<JobSeekerSave>) jobSeekerSaveRepository.findByUserId(user_account_id);
	}
	public Optional<JobSeekerSave> getOne(Integer Id) {
		return jobSeekerSaveRepository.findById(Id);
	}
	public void addNew(JobSeekerSave jobSeekerApply) {
		jobSeekerSaveRepository.save(jobSeekerApply);
	}
	public void update(JobSeekerSave jobSeekerApply) {
		jobSeekerSaveRepository.save(jobSeekerApply);
	}
	public void delete(Integer Id) {
		jobSeekerSaveRepository.deleteById(Id);
	}

}
