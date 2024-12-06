package com.schoolmgmt.service;


import java.text.ParseException;

import org.hibernate.SessionFactory;

public interface StudentService {
	
	void insertStudent(SessionFactory sf) throws ParseException,com.google.protobuf.TextFormat.ParseException;

	void updateStudent(SessionFactory sf);

	void deleteStudent(SessionFactory sf);

	void getAllStudent(SessionFactory sf);

	void getstudent(SessionFactory sf);
}