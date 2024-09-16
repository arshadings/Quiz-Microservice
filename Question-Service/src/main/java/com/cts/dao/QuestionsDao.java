package com.cts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.entity.Questions;


@Repository
public interface QuestionsDao extends JpaRepository<Questions, Integer> {
	
	List<Questions> findByCATEGORY(String category);

	@Query( value= "SELECT q.id from questions q where q.CATEGORY=:category ORDER BY RANDOM() LIMIT:numQ", nativeQuery=true )
	List<Integer> findRandomQuestionsByCategory(String category, int numQ);

}
