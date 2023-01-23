package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document("teacher")
public class Teacher {

	@Id
	@MongoId
	private Long teacherId;
	
	private String teacherName;
	
	private String reportingHOD;
	
	private Integer registerNumber;
	
	
}
