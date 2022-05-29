package com.kindsonthegenius.thymeleafapp.services;

import antlr.StringUtils;
import com.kindsonthegenius.thymeleafapp.models.RecruiterProfile;
import com.kindsonthegenius.thymeleafapp.repositories.RecruiterProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterProfileService {

	@Autowired
	private RecruiterProfileRepository recruiterRepository;
	@Autowired

	public List<RecruiterProfile> getAll() {
		return (List<RecruiterProfile>) recruiterRepository.findAll();
	}
	public Optional<RecruiterProfile> getOne(Integer Id) {
		return recruiterRepository.findById(Id);
	}
	public void addNew(RecruiterProfile RecruiterProfile) {
		recruiterRepository.save(RecruiterProfile);
	}
	public void update(RecruiterProfile RecruiterProfile) {
		recruiterRepository.save(RecruiterProfile);
	}
	public void delete(Integer Id) {
		recruiterRepository.deleteById(Id);
	}

//	public void saveRecruiter(MultipartFile file, String first_name, String last_name, String city, String state, String country, String company)
//	{
//		RecruiterProfile recruiterProfile = new RecruiterProfile();

//	}

}
