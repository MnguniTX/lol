package com.ratex.application.RatEX.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ratex.application.RatEX.entities.User;


@Transactional
@Service
@Component
//Interface UserRepo extends JpaRepository
//in order to acquire CRUD operations
public interface UserRepo extends JpaRepository<User, Long>{
	//method to find by email
	public User findByemail(String email);

}
