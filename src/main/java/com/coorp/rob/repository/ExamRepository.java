package com.coorp.rob.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coorp.rob.model.Exam;

@Repository
public interface ExamRepository extends MongoRepository<Exam, String>{

}
