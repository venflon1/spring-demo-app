package com.coorp.rob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coorp.rob.model.Student;
import com.coorp.rob.repository.StudenteRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudenteRepository studenteRepository;
	
	public void save(Student student) {
		this.studenteRepository.save(student);
	}
	
	public List<Student> getAll(){
		List<Student> list = this.studenteRepository.findAll();
		
		return list;
	}
	
	public Student getByMatricola(String matricola) {
		Student student = this.studenteRepository.findByMatricola(matricola);
		return student;
	}

}
