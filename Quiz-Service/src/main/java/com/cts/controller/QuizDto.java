package com.cts.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QuizDto {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long dtoId;
	private String categoryName;
	private Integer numQuestions;
	private String title;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getNumQuestions() {
		return numQuestions;
	}
	public void setNumQuestions(Integer numQuestions) {
		this.numQuestions = numQuestions;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "QuizDto [categoryName=" + categoryName + ", numQuestions=" + numQuestions + ", title=" + title + "]";
	}
	
	
	

}
