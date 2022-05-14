package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.Student;
import com.kindsonthegenius.thymeleafapp.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {

}
