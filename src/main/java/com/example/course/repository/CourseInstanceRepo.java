package com.example.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course.Entity.CourseInstance;

@Repository
public interface CourseInstanceRepo extends JpaRepository<CourseInstance,Integer> {
	
	 List<CourseInstance> findByYearAndSemester(int year, int semester);
	 List<CourseInstance> findByCourseId(int courseId);
}
