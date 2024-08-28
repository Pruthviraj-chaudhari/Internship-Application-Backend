package com.example.course.controller;


import com.example.course.Entity.CourseData;
import com.example.course.Entity.CourseInstance;
import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Courses APIs
    @PostMapping("/courses")
    public String createCourse(@RequestBody CourseData courseData) {
         courseService.createCourse(courseData);
         return "success";
    }

    @GetMapping("/courses")
    public List<CourseData> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public CourseData getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

    // Course Instances APIs
    @PostMapping("/instances")
    public CourseInstance createCourseInstance(@RequestBody CourseInstance courseInstance) {
        return courseService.createCourseInstance(courseInstance);
    }

    @GetMapping("/instances/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(
            @PathVariable int year, @PathVariable int semester) {
        return courseService.getInstancesByYearAndSemester(year, semester);
    }

    @GetMapping("/instances/{year}/{semester}/{courseId}")
    public CourseInstance getInstanceById(
            @PathVariable int year, @PathVariable int semester, @PathVariable int courseId) {
        
    	CourseInstance obj = courseService.getInstanceById(year, semester, courseId);
    	
    	if(obj == null) {
    		return null;
    	}
    	
    	return obj;
    }

    @DeleteMapping("/instances/{year}/{semester}/{courseId}")
    public void deleteCourseInstance(
            @PathVariable int year, @PathVariable int semester, @PathVariable int courseId) {
        courseService.deleteCourseInstance(year, semester, courseId);
    }
}


//{
//    "id":1,
//    "courseTitle":"deep learning",
//    "code":"abc123",
//    "description":"saiyyad Banda Zindabad"
//}