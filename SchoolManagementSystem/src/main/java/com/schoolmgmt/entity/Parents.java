package com.schoolmgmt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "parents")

public class Parents {
	@Id
	private String ParentName;
	private Long parentPhNo;
	private String Email;

	  @ManyToOne
	    @JoinColumn(name = "StuId")
	    private Students students;
	  
	  public Parents() {
		  
	  }

	public String getParentName() {
		return ParentName;
	}

	public void setParentName(String parentName) {
		ParentName = parentName;
	}

	public Long getParentPhNo() {
		return parentPhNo;
	}

	public void setParentPhNo(Long parentPhNo) {
		this.parentPhNo = parentPhNo;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Parents [ParentName=" + ParentName + ", parentPhNo=" + parentPhNo + ", Email=" + Email + "]";
	}

	/*@Override
	public String toString() {
		return "Parents [ParentName=" + ParentName + ", parentPhNo=" + parentPhNo + ", Email=" + Email + ", students="
				+ students + "]";
	}*/
	
	  
}