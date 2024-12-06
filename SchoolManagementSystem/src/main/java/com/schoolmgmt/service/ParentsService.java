package com.schoolmgmt.service;


import org.hibernate.SessionFactory;

public interface ParentsService {
	
	void insertParent(SessionFactory sf);

	void updateParent(SessionFactory sf);

	void deleteParent(SessionFactory sf);

	void getAllParent(SessionFactory sf);

	void getParent(SessionFactory sf);

}