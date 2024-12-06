package com.schoolmgmt.service;
import org.hibernate.SessionFactory;

public interface SubjectService {
	
	void insertSubject(SessionFactory sf);

	void updateSubject(SessionFactory sf);

	void deleteSubject(SessionFactory sf);

	void getAllSubjects(SessionFactory sf);

	void getSubject(SessionFactory sf);

}