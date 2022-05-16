
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobTypeMaster;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerExperienceRepository;
import com.kindsonthegenius.thymeleafapp.repositories.JobTypeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTypeMasterService {

	@Autowired
	private JobTypeMasterRepository jobTypeMasterRepository;
	public List<JobTypeMaster> getAll() {
		return (List<JobTypeMaster>) jobTypeMasterRepository.findAll();
	}
	public Optional<JobTypeMaster> getOne(Integer Id) {
		return jobTypeMasterRepository.findById(Id);
	}
	public void addNew(JobTypeMaster jobTypeMaster) {
		System.out.println(("Add New Job Type Master : "));
		System.out.println(jobTypeMaster.toString());
		jobTypeMasterRepository.save(jobTypeMaster);
	}
	public void update(JobTypeMaster jobTypeMaster) {
		jobTypeMasterRepository.save(jobTypeMaster);
	}
	public void delete(Integer Id) {
		jobTypeMasterRepository.deleteById(Id);
	}

}
