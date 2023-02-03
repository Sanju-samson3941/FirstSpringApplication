package com.example.demo.service;

import java.util.List;
import java.util.OptionalLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
@Service
public class TeacherService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Teacher addTeacherDetails(Teacher teacherDetails) {
		
		OptionalLong maxId =mongoTemplate.findAll(Teacher.class).stream().mapToLong(Teacher::getTeacherId).max();		
		
		if(maxId.isPresent()) {
			
			teacherDetails.setTeacherId(maxId.getAsLong()+1);
			
		} else {
			teacherDetails.setTeacherId(1l);
		}
		
		return mongoTemplate.save(teacherDetails, "teacher");
	}
	public List<Teacher> getTeacherDetails(){
		return mongoTemplate.findAll(Teacher.class);
	}
	public Teacher getTeacherDetailById(Long teacherId) {
		return mongoTemplate.findById(teacherId, Teacher.class, "teacher");
	}
	public Teacher updateTeacherDetails(Long teacherId, Teacher teacher) {
		Query query=new Query();
		query.addCriteria(Criteria.where("teacherId").is(teacherId));
		teacher.setTeacherId(teacherId);
		return mongoTemplate.save(teacher);
	}
	public Teacher deleteTeahcerDetails(Long teacherId) {
		Query query= new Query();
		query.addCriteria(Criteria.where("teacherId").is(teacherId));
		
		return mongoTemplate.findAndRemove(query,Teacher.class, "teacher");
	}
	
}
