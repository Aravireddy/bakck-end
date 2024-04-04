

package com.academy.coursemanager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academy.coursemanager.exception.ResourceNotFoundException;
import com.academy.coursemanager.model.Course;
import com.academy.coursemanager.repository.CourseRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class CourseController {

  @Autowired
  CourseRepository courseRepository;

//  @GetMapping("/courses")
//  public ResponseEntity<List<Course>> getAllcourses(@RequestParam(required = false) String title) {
//	return null;
//   
//  }
  
  @GetMapping("/courses")
  public List<Course>getAllCourses() {
	  System.out.println("test");
      return courseRepository.findAll();
  }

//  @GetMapping("/courses/{id}")
//  public ResponseEntity<Course> getwebsiteById(@PathVariable("id") long id) {
//	return null;
// 
//  }

  @PostMapping("/courses")
  public Course createcourse(@RequestBody Course course) {
	   return courseRepository.save(course);
   
  }

  @PutMapping("/courses/{id}")
  public ResponseEntity<Course> updatewebsite(@PathVariable("id") long id, @RequestBody Course course) {
	return null;
  
  }

  // delete course rest api
  @DeleteMapping("/courses/{id}")
  public ResponseEntity < Map < String, Boolean >> deleteStudent(@PathVariable Long id) {
	  Course course = courseRepository.findById(id)
			  .orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));

	  courseRepository.delete(course);
      Map < String, Boolean > response = new HashMap < > ();
      response.put("deleted", Boolean.TRUE);
      return ResponseEntity.ok(response);
  }

  

  
}

//– @CrossOrigin is for configuring allowed origins.
//– @RestController annotation is used to define a controller and to indicate that the return value of the methods should be be bound to the web response body.
//– @RequestMapping("/api") declares that all Apis’ url in the controller will start with /api.
//– We use @Autowired to inject websiteRepository bean to local variable.


