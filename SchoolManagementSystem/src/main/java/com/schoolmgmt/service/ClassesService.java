package com.schoolmgmt.service;


import org.hibernate.SessionFactory;

public interface ClassesService {
	
		void insertClasses(SessionFactory sf);

		void updateClasses(SessionFactory sf);

		void deleteClasses(SessionFactory sf);

		void getAllClasses(SessionFactory sf);

		void getClasses(SessionFactory sf);

}