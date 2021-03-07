package com.coorp.rob.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coorp.rob.model.Exam;
import com.coorp.rob.model.Student;
import com.coorp.rob.service.ExamService;
import com.coorp.rob.service.StudentService;

/**
 * @author Roberto
 * 
 * */
@RestController
@RequestMapping("/api/")
public class StudentController {

	private static Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ExamService examService;

	@RequestMapping(value = "student/{matricola}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable String matricola){
		log.info("getStudent - START - matricola={}", matricola);
		Student student = this.studentService.getByMatricola(matricola);
		log.info("getStudent - END");
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PostMapping(value = "student/{matricola}/esame")
	public ResponseEntity<Student> getStudent(@PathVariable String matricola, @RequestBody Exam exam) throws Exception{
		log.info("getStudent - START - matricola={}, esame={}", matricola, exam);
		Student studente = this.studentService.getByMatricola(matricola);
		studente.getEsami().add(exam);
		this.studentService.save(studente);
		log.info("getStudent - END");
		return new ResponseEntity<Student>(studente, HttpStatus.OK);
	}
	
	
}
