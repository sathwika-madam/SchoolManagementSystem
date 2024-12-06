package com.schoolmgmt.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Classes {
	@Id
	private Integer ClassId;
	private String ClassName;

	@ManyToOne
	@JoinColumn(name = "teacherId")
	private Teachers teachers;

	@OneToMany(mappedBy = "classes")
	private List<Grades> grades;

	@OneToMany(mappedBy ="classes")
	private List<Attendance> attendanceRecords;
	
	@OneToMany(mappedBy="classes",cascade=CascadeType.ALL)
	List<Students> students=new ArrayList<Students>();
	
	public Classes() {
		
	}

	public Integer getClassId() {
		return ClassId;
	}

	public void setClassId(Integer classId) {
		ClassId = classId;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public Teachers getTeacher() {
		return teachers;
	}

	public void setTeacher(Teachers teachers) {
		this.teachers = teachers;
	}

	public List<Grades> getGrades() {
		return grades;
	}

	public void setGrades(List<Grades> grades) {
		this.grades = grades;
	}

	public List<Attendance> getAttendanceRecords() {
		return attendanceRecords;
	}

	public void setAttendanceRecords(List<Attendance> attendanceRecords) {
		this.attendanceRecords = attendanceRecords;
	}

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classes [ClassId=" + ClassId + ", ClassName=" + ClassName + "]";
	}

	/*@Override
	public String toString() {
		return "Classes [ClassId=" + ClassId + ", ClassName=" + ClassName + ", teachers=" + teachers + "]";
	}*/
	
	
	
}