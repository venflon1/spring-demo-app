package com.coorp.rob.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coorp.rob.model.Student;

@Repository
public interface StudenteRepository extends MongoRepository<Student, String>{

	public Student findByMatricola(String matricola);
}
