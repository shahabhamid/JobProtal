
package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobLocation;
import com.kindsonthegenius.thymeleafapp.repositories.JobLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobLocationService {

	@Autowired
	private JobLocationRepository jobLocationRepository;
	public List<JobLocation> getAll() {
		return (List<JobLocation>) jobLocationRepository.findAll();
	}
	public Optional<JobLocation> getOne(Integer Id) {
		return jobLocationRepository.findById(Id);
	}
	public void addNew(JobLocation jobLocation) {
		System.out.println(("Add New Job Location : "));
		System.out.println(jobLocation.toString());
		jobLocationRepository.save(jobLocation);
	}
	public void update(JobLocation jobLocation) {
		jobLocationRepository.save(jobLocation);
	}
	public void delete(Integer Id) {
		jobLocationRepository.deleteById(Id);
	}

}
