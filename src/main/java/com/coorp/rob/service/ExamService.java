package com.coorp.rob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coorp.rob.model.Exam;
import com.coorp.rob.repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	public void save(Exam exam) {
		this.examRepository.save(exam);
	}
	
	public List<Exam> getAll(){
		List<Exam> list = this.examRepository.findAll();
		
		return list;
	}
}
