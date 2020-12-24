package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	List<Courses> list;
	public CourseServiceImpl() {
		list  = new ArrayList<>();
		list.add(new Courses(145, "Java Course", "this is java course")); 
		list.add(new Courses(146, "Python Course", "this is Python course")); 
	} 
	
	@Override
	public List<Courses> getCourses() {
		return list;
	}

	@Override
	public Courses getCourse(long courseId) {
		
		Courses c = null; 
		for(Courses course : list) {
			if(course.getId() == courseId) {
				c = course; 
				break; 
			}
		}
		
		return c;
	}

	@Override
	public Courses addCourse(Courses course) {
		list.add(course); 
		return course;
	}

	@Override
	public String updateCourse(Courses course) {
		for(Courses c : list) {
			if (c.getId() == course.getId()) {
//				System.out.println("Got it");
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
				break; 
			}
		}
		return "Updated";
	}
	
	

}
