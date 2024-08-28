package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.course.Entity.CourseData;

@Repository
public interface CoursedataRepo extends JpaRepository<CourseData,Integer> {

}
