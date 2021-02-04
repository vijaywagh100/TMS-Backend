package com.training.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.tms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String username);
	
}
