package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.UsersType;
import com.kindsonthegenius.thymeleafapp.repositories.UsersTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersTypeService {

	@Autowired
	private UsersTypeRepository usersTypeRepository;
	public List<UsersType> getAll() {
		return (List<UsersType>) usersTypeRepository.findAll();
	}
	public Optional<UsersType> getOne(Integer Id) {
		return usersTypeRepository.findById(Id);
	}
	public void addNew(UsersType usersType) {
		System.out.println(("Add New User Type: "));
		System.out.println(usersType.toString());
		usersTypeRepository.save(usersType);
	}
	public void update(UsersType usersType) {
		usersTypeRepository.save(usersType);
	}
	public void delete(Integer Id) {
		usersTypeRepository.deleteById(Id);
	}

}
