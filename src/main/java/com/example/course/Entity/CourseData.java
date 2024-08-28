package com.example.course.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_table")
public class CourseData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String courseTitle;
   private String code;
   private String description;
   
   
		public CourseData(int id, String courseTitle, String code, String description) {
			super();
			this.id = id;
			this.courseTitle = courseTitle;
			this.code = code;
			this.description = description;
		}
		
		public CourseData() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCourseTitle() {
			return courseTitle;
		}
		public void setCourseTitle(String courseTitle) {
			this.courseTitle = courseTitle;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

	

		
		   
   
   
   
}
