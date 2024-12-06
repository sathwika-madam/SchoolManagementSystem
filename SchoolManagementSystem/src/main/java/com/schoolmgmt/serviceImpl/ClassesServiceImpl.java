package com.schoolmgmt.serviceImpl;



import java.util.List;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.schoolmgmt.entity.Classes;
import com.schoolmgmt.entity.Teachers;
import com.schoolmgmt.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {
	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertClasses(SessionFactory sf) {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		Classes classes = new Classes();
		System.out.println("Enter values for classes i.e classId and name");
		int classId = sc.nextInt();
		classes.setClassId(classId);
		String name = sc.next();
		classes.setClassName(name);
		System.out.println("Enter TeacherId  for classes:");
		int teacherId = sc.nextInt();
		Teachers teachers = session.get(Teachers.class, teacherId);
		classes.setTeachers(teachers);
		session.persist(classes);
		session.saveOrUpdate(teachers);
		transacation.commit();
		session.close();
		
	}
	
	public void updateClasses(SessionFactory sf) {
		try(Session session = sf.openSession()){
		Transaction transaction = session.beginTransaction();
		
		Classes classes;
		while (true) {
			System.out.println(
					"choose option for update \n 1.update classname\n 2.update TeacherId \n 3.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("enter class Id:");
				classes = session.get(Classes.class, sc.nextInt());
				System.out.println("enter new class name:");
				classes.setClassName(sc.next());
				session.saveOrUpdate(classes);
				transaction.commit();
				break;
			case 2:
				System.out.println("enter class id:");
				classes = session.get(Classes.class, sc.nextInt());
				System.out.println("enter Teacher Id:");
				int id = sc.nextInt();
				Teachers teachers = session.get(Teachers.class, id);
				classes.setTeachers(teachers);
				session.saveOrUpdate(classes);
				transaction.commit();
				break;
			case 3:
				System.out.println("exiting from update classes");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid option");
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteClasses(SessionFactory sf) {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		System.out.println("enter class Id");
		int classId = sc.nextInt();
		Classes classes = session.get(Classes.class,classId);
		session.delete(classes);
		transacation.commit();
		session.close();
		
	}

	
	public void getAllClasses(SessionFactory sf) {
		session = sf.openSession();
		Query createQuery = session.createQuery("from Classes");
		  
	    List<Classes> resultList = createQuery.getResultList();
	    
	    for(Classes c:resultList)
	    	System.out.println(c);
	    session.close();
	}

	public void getClasses(SessionFactory sf) {
		
		session = sf.openSession();
		System.out.println("enter class id:");
		int classId=sc.nextInt();
		Classes classes=session.get(Classes.class,classId);
		System.out.println(classes);
		session.close();
}
	
}