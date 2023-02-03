package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	
	@PostMapping("/insertTeacher")
	public Teacher addTeacherDetails(@RequestBody Teacher teacherObject) {
		
		
		return teacherService.addTeacherDetails(teacherObject);
	}
	@GetMapping("/getTeacherDetails")
	public List<Teacher> getTeacherDetails(){
		return teacherService.getTeacherDetails();
	}
	@GetMapping("/getTeacherDetailById")
	public Teacher getTeacherDetailById(Long teacherId) {
		return teacherService.getTeacherDetailById(teacherId);
	}
	@PostMapping("/updateTeacherDetails/{teacherId}")
	public Teacher updateTeacherDetailsById(@PathVariable Long teacherId,Teacher teacher) {
		return teacherService.updateTeacherDetails(teacherId,teacher);
	}
	@DeleteMapping("/deletingTeacherDetails")
	public Teacher deleteTeacherDetails(Long teacherId) {
		return teacherService.deleteTeahcerDetails(teacherId);
	}
}
