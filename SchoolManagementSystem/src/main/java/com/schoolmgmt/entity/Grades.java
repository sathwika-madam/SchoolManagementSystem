package com.schoolmgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Grades {
	@Id
	private String GradeValue;
	
	@ManyToOne
    @JoinColumn(name="StuId")
    private Students students;

    @ManyToOne
    @JoinColumn(name="ClassId")
    private Classes classes;

    @ManyToOne
    @JoinColumn(name="subId")
    private Subjects subjects;

    
    public Grades() {
    	
    }


	public String getGradeValue() {
		return GradeValue;
	}


	public void setGradeValue(String gradeValue) {
		GradeValue = gradeValue;
	}


	public Students getStudents() {
		return students;
	}


	public void setStudents(Students students) {
		this.students = students;
	}


	public Classes getClasses() {
		return classes;
	}


	public void setClasses(Classes classes) {
		this.classes = classes;
	}


	public Subjects getSubjects() {
		return subjects;
	}


	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}


	@Override
	public String toString() {
		return "Grades [GradeValue=" + GradeValue + "]";
	}


	/*@Override
	public String toString() {
		return "Grades [GradeValue=" + GradeValue + ", students=" + students + ", classes=" + classes + ", subjects="
				+ subjects + "]";
	}*/
	


}