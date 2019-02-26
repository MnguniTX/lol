package com.ratex.application.RatEX.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ratex.application.RatEX.entities.GraphGBP;

@Transactional
@Service
@Component
//Interface GraphGBPRepo extends JpaRepository
//in order to acquire CRUD operations
public interface GraphGBPRepo extends JpaRepository<GraphGBP, Long> {

}
