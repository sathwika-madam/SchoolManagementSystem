package com.schoolmgmt.entity;



import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import org.hibernate.annotations.Parent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Students {
	@Id
	private Integer StuId;
	private String Name;
	private LocalDate DOB;
	private Long Phno;
	private String Email;
	private String Address;
	private LocalDate EnrollDate;
	
	 @OneToMany(mappedBy = "students")
	    private List<Parents> parents;

	    @OneToMany(mappedBy = "students")
	    private List<Grades> grades;

	    @OneToMany(mappedBy = "students")
	    private List<Attendance> attendanceRecords;
	    
	    @ManyToOne
		@JoinColumn(name="classId")
		private Classes classes;
	    
	    public Students() {
	    	
	    }

		public Integer getStuId() {
			return StuId;
		}

		public void setStuId(Integer stuId) {
			StuId = stuId;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public LocalDate getDOB() {
			return DOB;
		}

		public void setDOB(LocalDate dOB) {
			DOB = dOB;
		}

		public Long getPhno() {
			return Phno;
		}

		public void setPhno(Long phno) {
			Phno = phno;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public LocalDate getEnrollDate() {
			return EnrollDate;
		}

		public void setEnrollDate(LocalDate date1) {
			EnrollDate = date1;
		}

		public List<Parents> getParents() {
			return parents;
		}

		public void setParents(List<Parents> parents) {
			this.parents = parents;
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

		public Classes getClasses() {
			return classes;
		}

		public void setClasses(Classes classes) {
			this.classes = classes;
		}

		@Override
		public String toString() {
			return "Students [StuId=" + StuId + ", Name=" + Name + ", DOB=" + DOB + ", Phno=" + Phno + ", Email="
					+ Email + ", Address=" + Address + ", EnrollDate=" + EnrollDate + "]";
		}

		/*@Override
		public String toString() {
			return "Students [StuId=" + StuId + ", Name=" + Name + ", DOB=" + DOB + ", Phno=" + Phno + ", Email="
					+ Email + ", Address=" + Address + ", EnrollDate=" + EnrollDate + ", classes=" + classes + "]";
		}*/
		
		
}
