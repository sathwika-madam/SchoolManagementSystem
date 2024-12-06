package com.schoolmgmt.entity;


import java.util.List;

import javax.security.auth.Subject;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Teachers {
	@Id
	private Integer teacherId;
	private String teacherName;
	private Long phno;
	private String Email;
	
	
	@ManyToOne
    @JoinColumn(name = "SubId")
    private Subjects subjects;

    @OneToMany(mappedBy = "teachers",cascade=CascadeType.ALL)
    private List<Classes> classes;
    
    public Teachers() {
    	
    }

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public Subjects getSubject() {
		return subjects;
	}

	public void setSubject(Subjects subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Teachers [teacherId=" + teacherId + ", teacherName=" + teacherName + ", phno=" + phno + ", Email="
				+ Email + "]";
	}

	/*@Override
	public String toString() {
		return "Teachers [teacherId=" + teacherId + ", teacherName=" + teacherName + ", phno=" + phno + ", Email="
				+ Email + ", subjects=" + subjects + "]";
	}  */
	
	
}