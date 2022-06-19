package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.JobSeekerProfileRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerProfileService {

	@Autowired
	private JobSeekerProfileRepository jobSeekerProfileRepository;

	@Autowired
	private UsersRepository usersRepository;

	public List<JobSeekerProfile> getAll() {
		return (List<JobSeekerProfile>) jobSeekerProfileRepository.findAll();
	}
	public Optional<JobSeekerProfile> getOne(Integer Id) {
		return jobSeekerProfileRepository.findById(Id);
	}
	public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
		return jobSeekerProfileRepository.save(jobSeekerProfile);
	}
	public void update(JobSeekerProfile jobSeekerProfile) {
		jobSeekerProfileRepository.save(jobSeekerProfile);
	}
	public void delete(Integer Id) {
		jobSeekerProfileRepository.deleteById(Id);
	}

	public JobSeekerProfile getCurrentSeekerProfile(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Users user  =  usersRepository.findByEmail(currentUserName);
			Optional<JobSeekerProfile> jobSeekerProfile = getOne(user.getUser_id());
			return jobSeekerProfile.orElse(null);
		}else return null;
	}
}
