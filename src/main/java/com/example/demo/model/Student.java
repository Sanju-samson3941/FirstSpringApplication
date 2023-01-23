package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document("student")
public class Student {
	
	@Id
	@MongoId
	private Long studentId;

	private String studentName;
	
	private String studentDeparment;
	
	private String studentRegistrationNumber;
	
	private String fatherName;
	
	private Integer fatherPhone;
}
