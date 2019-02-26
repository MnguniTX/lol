package com.ratex.application.RatEX.daos;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ratex.application.RatEX.entities.Currency;


@Transactional
@Service
@Component
//Interface CurrencyRepo extends JpaRepository
//in order to acquire CRUD operations
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
	
}
