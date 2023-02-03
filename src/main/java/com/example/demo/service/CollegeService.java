package com.example.demo.service;

import java.util.List;
import java.util.OptionalLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.demo.model.College;

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
	public List<College> getCollegeDetailsByCollegeRating(Integer collegeRating){
		Query query = new Query();
		query.addCriteria(Criteria.where("collegeRating").is(collegeRating));
		return mongoTemplate.find(query, College.class);
		
	}
	public College updateCollegeDetails(Long _id, College college) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(_id));
		college.setCollegeId(_id);
		return mongoTemplate.save(college);
		
	}
	public College deleteCollegeDetails(Long collegeId) {
		Query query= new Query();
		query.addCriteria(Criteria.where("collegeId").is(collegeId));
		return mongoTemplate.findAndRemove(query, College.class, "college");
	}
	
	
	
}
