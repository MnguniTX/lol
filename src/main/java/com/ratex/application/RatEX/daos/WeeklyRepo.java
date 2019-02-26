package com.ratex.application.RatEX.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratex.application.RatEX.entities.Weekly;

public interface WeeklyRepo extends JpaRepository<Weekly, Long> {

}
