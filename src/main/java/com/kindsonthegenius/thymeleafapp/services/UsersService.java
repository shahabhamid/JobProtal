package com.kindsonthegenius.thymeleafapp.services;

import com.kindsonthegenius.thymeleafapp.models.Users;
import com.kindsonthegenius.thymeleafapp.repositories.UsersRepository;
import com.kindsonthegenius.thymeleafapp.repositories.UsersTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UsersTypeRepository usersTypeRepository;
	public List<Users> getAll() {
		return (List<Users>)  usersRepository.findAll();
	}

	public Optional<Users> getOne(Integer Id) {
		return usersRepository.findById(Id);
	}
	public Users addNew(Users user) throws Exception {
		return usersRepository.save(user);
	}
	public void update(Users user) {
		usersRepository.save(user);
	}
	public void delete(Integer Id) {
		usersRepository.deleteById(Id);
	}

}
