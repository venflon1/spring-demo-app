package com.coorp.rob;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

import com.coorp.rob.model.Exam;
import com.coorp.rob.model.Student;
import com.coorp.rob.mongo.eventlistner.CascadingMongoEventListener;
import com.coorp.rob.service.ExamService;
import com.coorp.rob.service.StudentService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ExamService examService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student s = new Student();
		s.setMatricola("830650");

		this.studentService.save(s);
	}

	@Bean("userCascadingMongoEventListener")
	public CascadingMongoEventListener geUserCascadingMongoEventListener() {
		return new CascadingMongoEventListener();
	}

	@Bean
	MongoTransactionManager txManager(MongoDbFactory dbFactory) {
		return new MongoTransactionManager(dbFactory);
	}
}
