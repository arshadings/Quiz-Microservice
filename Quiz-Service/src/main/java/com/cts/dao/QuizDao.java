package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.Quiz;

@Repository
public interface QuizDao  extends JpaRepository<Quiz, Integer> {

}
