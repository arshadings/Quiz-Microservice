package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.dao.QuestionsDao;
import com.cts.entity.QuestionWrapper;
import com.cts.entity.Questions;
import com.cts.entity.Response;

@Service
public class QuestionService {

	@Autowired
	QuestionsDao questionsDao;
	
	public ResponseEntity<List<Questions>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionsDao.findAll(), HttpStatus.OK);	
		} catch( Exception e  ) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionsDao.findByCATEGORY(category), HttpStatus.OK);
		} catch( Exception e  ) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestions(Questions questions) {
		questionsDao.save(questions);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
		List<Integer> questions = questionsDao.findRandomQuestionsByCategory( categoryName, numQuestions );
		return new ResponseEntity<>(questions, HttpStatus.OK) ;
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Questions> questions = new ArrayList<>();
		
		for( Integer id: questionIds ) {
			questions.add( questionsDao.findById(id).get() );
		}
		System.out.println("questions: "+questions);
		
		for( Questions q: questions ) {
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setID(q.getID());
			wrapper.setQUESTIONTITLE(q.getQUESTIONTITLE());
			wrapper.setOPTION1(q.getOPTION1());
			wrapper.setOPTION2(q.getOPTION2());
			wrapper.setOPTION3(q.getOPTION3());
			wrapper.setOPTION4(q.getOPTION4());
			wrappers.add(wrapper);
		}
		
		return new ResponseEntity<>(wrappers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int score = 0;
		for( Response r: responses ) {
			Questions question = questionsDao.findById(r.getId()).get();
			if( r.getResponse().equals(question.getANSWER()) )
				score++;
		}
		return new ResponseEntity<>(score, HttpStatus.OK);
	}

}
