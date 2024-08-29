package com.example.course;

public class CourseInstanceModel {
  private int id;
  private int year;
  private int semester;
  
  
public CourseInstanceModel(int id, int year, int semester) {
	super();
	this.id = id;
	this.year = year;
	this.semester = semester;
}


public CourseInstanceModel() {
	super();
	// TODO Auto-generated constructor stub
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
  
  
}
