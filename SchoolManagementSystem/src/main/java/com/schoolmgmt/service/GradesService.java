package com.schoolmgmt.service;

import org.hibernate.SessionFactory;

public interface GradesService {
	
	void insertGrade(SessionFactory sf);

	void updateGrade(SessionFactory sf);

	void deleteGrade(SessionFactory sf);

	void getAllGrade(SessionFactory sf);

	void getGrade(SessionFactory sf);

}