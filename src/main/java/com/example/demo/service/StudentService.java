package com.example.demo.service;

import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
@Service
public class StudentService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Student addStudentDetails(Student studentDetails) {
		
		OptionalLong maxId =mongoTemplate.findAll(Student.class).stream().mapToLong(Student::getStudentId).max();		
		
		if(maxId.isPresent()) {
			
			studentDetails.setStudentId(maxId.getAsLong()+1);
			
		} else {
			studentDetails.setStudentId(1l);
		}
		
		return mongoTemplate.save(studentDetails, "student");
	}
}
