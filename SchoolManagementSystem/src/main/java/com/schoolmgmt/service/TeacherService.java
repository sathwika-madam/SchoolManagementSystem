package com.schoolmgmt.service;


import org.hibernate.SessionFactory;

public interface TeacherService {
	
	void insertTeacher(SessionFactory sf);

	void updateTeacher(SessionFactory sf);

	void deleteTeacher(SessionFactory sf);

	void getAllTeacher(SessionFactory sf);

	void getTeacher(SessionFactory sf);

}