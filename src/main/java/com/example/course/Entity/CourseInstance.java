package com.example.course.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_instance")
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private int semester;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseData course;
    
    public CourseInstance() {}

    public CourseInstance(int id, int year, int semester, CourseData course) {
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.course = course;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public CourseData getCourse() {
		return course;
	}

	public void setCourse(CourseData course) {
		this.course = course;
	}

    
}