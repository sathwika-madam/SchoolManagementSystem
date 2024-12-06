package com.schoolmgmt.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.schoolmgmt.entity.Classes;
import com.schoolmgmt.entity.Subjects;
import com.schoolmgmt.entity.Teachers;
import com.schoolmgmt.service.SubjectService;

public class SubjectServiceImpl implements SubjectService{
	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertSubject(SessionFactory sf) {
		session=sf.openSession();
		Transaction transaction=session.beginTransaction();	
		Subjects subjects=new Subjects();
		Teachers teacher=new Teachers();
		System.out.println("Enter values for subjects:");
		System.out.println("Enter subjectId and subjectName");
		int num = sc.nextInt();
		subjects.setSubId(num);
		String c = sc.next();
		subjects.setSubName(c);
		System.out.println("Enter classId  for subjects:");
		int classId = sc.nextInt();
		Classes classes = session.get(Classes.class, classId);
		session.saveOrUpdate(classes);
		session.persist(subjects);
		transaction.commit();
		session.close();
	}

	
	public void updateSubject(SessionFactory sf) {
		session=sf.openSession();
		Transaction transaction=session.beginTransaction();	
		Subjects subjects;
		while (true) {
			System.out.println("choose option for update \n1.update subject Name \n 2.Exit");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter subjectId:");
				subjects=session.get(Subjects.class,sc.nextInt());
				System.out.println("Enter Subject Name:");
				subjects=session.get(Subjects.class,sc.next());
				session.saveOrUpdate(subjects);
				transaction.commit();
				break;
			case 2:
				System.out.println("existing from update subject:");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid option");	
			}}
	}
	
	public void deleteSubject(SessionFactory sf) {
		session=sf.openSession();
		Transaction transaction=session.beginTransaction();	

		System.out.println("Enter subjectId:");
		int id=sc.nextInt();
		Subjects subjects=session.get(Subjects.class, id);
		session.delete(subjects);
		transaction.commit();
		session.close();	

	}
	
	public void getAllSubjects(SessionFactory sf) {
		session=sf.openSession();
		Query query=session.createQuery("from subjects");
		List<Subjects> resultList=query.getResultList();

		for(Subjects c:resultList)
			System.out.println(c);
		session.close();
	}

	
	public void getSubject(SessionFactory sf) {
		session=sf.openSession();
		System.out.println("enter subject id:");
		int id=sc.nextInt();
		Subjects subjects=session.get(Subjects.class,id);
		System.out.println(subjects);
		session.close();		
	}


}