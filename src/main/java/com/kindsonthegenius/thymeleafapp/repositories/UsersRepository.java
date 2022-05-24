package com.kindsonthegenius.thymeleafapp.repositories;

import com.kindsonthegenius.thymeleafapp.models.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    public Users findByEmail(String email);
}
