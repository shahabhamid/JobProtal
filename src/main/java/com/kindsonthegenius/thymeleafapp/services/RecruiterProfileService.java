package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.RecruiterProfile;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.RecruiterProfileRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterProfileService {

	@Autowired
	private RecruiterProfileRepository recruiterRepository;
	@Autowired
	private UsersRepository usersRepository;

	public List<RecruiterProfile> getAll() {
		return (List<RecruiterProfile>) recruiterRepository.findAll();
	}
	public Optional<RecruiterProfile> getOne(Integer Id) {
		return recruiterRepository.findById(Id);
	}
	public RecruiterProfile addNew(RecruiterProfile RecruiterProfile) {
		return recruiterRepository.save(RecruiterProfile);
	}
	public void update(RecruiterProfile RecruiterProfile) {
		recruiterRepository.save(RecruiterProfile);
	}
	public void delete(Integer Id) {
		recruiterRepository.deleteById(Id);
	}

	public RecruiterProfile getCurrentRecruiterProfile(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			Users user  =  usersRepository.findByEmail(currentUserName);
			Optional<RecruiterProfile> recruiterProfile = getOne(user.getUser_id());
			return recruiterProfile.orElse(null);
		}else return null;
	}

}
