package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.College;
import com.example.demo.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	
	@PostMapping("/insertCollege")
	public College addCollegeDetails(@RequestBody College collegeObject) {
		
		
		return collegeService.addCollegeDetails(collegeObject);
	}
	@GetMapping("/getCollegeDetails")
	public List<College> getCollegeDetails(){
		
		return collegeService.getCollegeDetails();
	}
	@GetMapping("/getCollegeById")
	public College getCollegeDetails(Long collegeId) {
		return collegeService.getCollegeDetailById(collegeId);
	}
	
	
}
