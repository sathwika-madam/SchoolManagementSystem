package com.schoolmgmt.entity;


import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Attendance {
	@Id
	private LocalDate date;
	private String status;
	
	
	 @ManyToOne
	 @JoinColumn(name="StuId")
	    private Students students;

	    @ManyToOne
	    @JoinColumn(name="ClassId")
	    private Classes classes;
	    
	    public Attendance() {
	    	
	    }

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
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

		@Override
		public String toString() {
			return "Attendance [date=" + date + ", status=" + status + "]";
		}

		/*@Override
		public String toString() {
			return "Attendance [date=" + date + ", status=" + status + ", students=" + students + ", classes=" + classes
					+ "]";
		}*/
		
	    

}