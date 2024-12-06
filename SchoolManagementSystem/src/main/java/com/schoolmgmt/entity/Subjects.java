package com.schoolmgmt.entity;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Subjects {
	@Id
	private Integer subId;
	private String subName;

	 @OneToMany(mappedBy = "subjects")
	    private List<Teachers> teachers;

	    @OneToMany(mappedBy = "subjects")
	    private List<Grades> grades;
	    
	    public Subjects() {
	    	
	    }

		public Integer getSubId() {
			return subId;
		}

		public void setSubId(Integer subId) {
			this.subId = subId;
		}

		public String getSubName() {
			return subName;
		}

		public void setSubName(String subName) {
			this.subName = subName;
		}

		public List<Teachers> getTeachers() {
			return teachers;
		}

		public void setTeachers(List<Teachers> teachers) {
			this.teachers = teachers;
		}

		public List<Grades> getGrades() {
			return grades;
		}

		public void setGrades(List<Grades> grades) {
			this.grades = grades;
		}

		@Override
		public String toString() {
			return "Subjects [subId=" + subId + ", subName=" + subName + "]";
		}

		/*@Override
		public String toString() {
			return "Subjects [subId=" + subId + ", subName=" + subName + ", teachers=" + teachers + "]";
		}*/
		
	    

}