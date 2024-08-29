package com.example.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.CourseInstanceModel;
import com.example.course.Entity.CourseData;
import com.example.course.Entity.CourseInstance;
import com.example.course.repository.CourseInstanceRepo;
import com.example.course.repository.CoursedataRepo;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CoursedataRepo courseDataRepository;

    @Autowired
    private CourseInstanceRepo courseInstanceRepository;

    // Course CRUD
    public CourseData createCourse(CourseData courseData) {
        return courseDataRepository.save(courseData);
    }

    public List<CourseData> getAllCourses() {
        return courseDataRepository.findAll();
    }

    public CourseData getCourseById(int id) {
        return courseDataRepository.findById(id).orElse(null);
    }

    // Modified deleteCourse method to delete related CourseInstance entries
    public void deleteCourse(int id) {
        // First, delete all CourseInstance entries associated with the Course
        List<CourseInstance> instances = courseInstanceRepository.findByCourseId(id);
        for (CourseInstance instance : instances) {
            courseInstanceRepository.delete(instance);
        }

        // Then, delete the CourseData entry itself
        courseDataRepository.deleteById(id);
    }

    // CourseInstance 
    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.save(courseInstance);
    }

    public List<CourseInstance> getInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    public CourseInstance getInstanceById(int year, int semester, int courseId) {
        return courseInstanceRepository.findByYearAndSemester(year, semester).stream()
                .filter(instance -> instance.getCourse().getId() == courseId)
                .findFirst()
                .orElse(null);
    }

    public void deleteCourseInstance(int year, int semester, int courseId) {
        CourseInstance instance = getInstanceById(year, semester, courseId);
        if (instance != null) {
            courseInstanceRepository.delete(instance);
        }
    }
    
    public void AddCourseInstance(CourseInstanceModel courseInstanceModel) {
    CourseData course = courseDataRepository.findById(courseInstanceModel.getId()).orElse(null);
    
    if(course!=null) {
        CourseInstance courseInstance=new CourseInstance();
        courseInstance.setCourse(course);
        courseInstance.setYear(courseInstanceModel.getYear());
        courseInstance.setSemester(courseInstanceModel.getSemester());
        courseInstanceRepository.save(courseInstance);
    }

    }
}
