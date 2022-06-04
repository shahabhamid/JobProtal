package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.JobSeekerProfile;
import com.kindsonthegenius.thymeleafapp.models.RecruiterProfile;
import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UsersTypeRepository usersTypeRepository;

	@Autowired
	private RecruiterProfileService recruiterProfile;
	@Autowired
	private JobSeekerProfileService seekerProfileService;


	public List<Users> getAll() {
		return (List<Users>)  usersRepository.findAll();
	}

	public Optional<Users> getOne(Integer Id) {
		return usersRepository.findById(Id);
	}
	public Users addNew(Users user) throws Exception {
		Users u = usersRepository.save(user);

		if(user.getUser_type_id().getUser_type_id()==1){
			recruiterProfile.addNew(new RecruiterProfile(user,"","","","","","",""));
		}else{
			seekerProfileService.addNew((new JobSeekerProfile(user)));
		}
		return u;
	}
	public void update(Users user) {
		usersRepository.save(user);
	}
	public void delete(Integer Id) {
		usersRepository.deleteById(Id);
	}

	public Users getCurrentUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			return  usersRepository.findByEmail(currentUserName);
		}
		return null;
	}

}
