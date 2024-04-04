
package com.academy.coursemanager.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.coursemanager.model.Course;



public interface CourseRepository extends JpaRepository<Course, Long> {
 
}
