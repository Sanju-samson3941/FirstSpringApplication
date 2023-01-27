package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	

	@PostMapping("/insertStudent")
	public Student addStudentDetails(@RequestBody Student studentObject) {
		
		
		return studentService.addStudentDetails(studentObject);
	}
	@GetMapping("/getStudentDetails")
	public List<Student> getStudentDetails(){
		return studentService.getStudentDetails();
	}
	@GetMapping("/getStudentDetailsById")
	public Student getStudentDetails(Long studentId ) {
		return studentService.getStudentDetailById(studentId);
		
	}
}
