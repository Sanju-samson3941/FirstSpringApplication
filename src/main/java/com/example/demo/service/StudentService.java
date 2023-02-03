package com.example.demo.service;

import java.util.List;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	public List<Student> getStudentDetails(){
		return mongoTemplate.findAll(Student.class);
	}
	public Student getStudentDetailById(Long studentId) {
		return mongoTemplate.findById(studentId, Student.class, "student");
   }
	public Student updateStudentDetailById(Long studentId, Student student) {
		Query query= new Query();
		query.addCriteria(Criteria.where("studentId").is(studentId));
		student.setStudentId(studentId);
		return mongoTemplate.save(student);
	}
	public Student deleteStudentDetailsById(Long studentId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("studentId").is(studentId));
		
		return mongoTemplate.findAndRemove(query, Student.class, "student");
	}
}
