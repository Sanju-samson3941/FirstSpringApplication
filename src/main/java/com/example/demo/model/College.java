package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document("college")
public class College {
	
	@Id
	@MongoId
	private Long collegeId;

	private List<String> departments;
	
	private List<String> officeStaff;
	
	private String affilieatedTo;
	
	private Integer collegeRating;
	
	
}
