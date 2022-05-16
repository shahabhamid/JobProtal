package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerSkillSet;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerSkillSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerSkillSetService {

	@Autowired
	private JobSeekerSkillSetRepository jobSeekerSkillSetRepository;
	public List<JobSeekerSkillSet> getAll() {
		return (List<JobSeekerSkillSet>) jobSeekerSkillSetRepository.findAll();
	}
	public Optional<JobSeekerSkillSet> getOne(Integer Id) {
		return jobSeekerSkillSetRepository.findById(Id);
	}
	public void addNew(JobSeekerSkillSet jobSeekerSkillSet) {
		System.out.println(("Add New Job Seeker Skill Set"));
		System.out.println(jobSeekerSkillSet.toString());
		jobSeekerSkillSetRepository.save(jobSeekerSkillSet);
	}
	public void update(JobSeekerSkillSet jobSeekerSkillSet) {
		jobSeekerSkillSetRepository.save(jobSeekerSkillSet);
	}
	public void delete(Integer Id) {
		jobSeekerSkillSetRepository.deleteById(Id);
	}

}
