package com.example.demo.service;

import java.util.List;
import java.util.OptionalLong;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.College;
import com.jayway.jsonpath.Criteria;

@Service
public class CollegeService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public College addCollegeDetails(College collegeDetails) {
		
		OptionalLong maxId =mongoTemplate.findAll(College.class).stream().mapToLong(College::getCollegeId).max();		
		
		if(maxId.isPresent()) {
			
			collegeDetails.setCollegeId(maxId.getAsLong()+1);
			
		} else {
			collegeDetails.setCollegeId(1l);
		}
		
		return mongoTemplate.save(collegeDetails, "college");
	}
	public List<College> getCollegeDetails(){
		return mongoTemplate.findAll(College.class);
		
	}
	public College getCollegeDetailById(Long collegeId) {
		return mongoTemplate.findById(collegeId, College.class, "college");
		
	}
	
	
}
