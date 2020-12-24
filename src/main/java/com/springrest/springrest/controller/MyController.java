package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	//Object of the interface - This is dependency injection (We are not creating object)
	@Autowired
	private CourseService courseService; 
	
	//Get the courses
	
	//Alternative to the below mapping ---> 
//	@RequestMapping(path="/courses", method=RequestMethod.GET)
	@GetMapping("/courses")
	public List<Courses> getCourses() {
		
		return this.courseService.getCourses(); 
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId)); 
	}
	
	@PostMapping(path="/courses", consumes="application/json")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course); 
	}

	@PutMapping(path="/courses/{courseId}", consumes="application/json")
	public String updateCourse(@RequestBody Courses course) {
		return this.courseService.updateCourse(course); 
	}
	
	
}
