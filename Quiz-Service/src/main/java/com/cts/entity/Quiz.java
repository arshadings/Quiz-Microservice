package com.cts.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
	private String title;
	
	@ElementCollection
	private List<Integer> QuestionIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getQuestionIds() {
		return QuestionIds;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		QuestionIds = questionIds;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", Questions=" + QuestionIds + "]";
	}
	
	

}
