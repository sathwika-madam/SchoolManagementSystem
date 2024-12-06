package com.schoolmgmt.serviceImpl;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.schoolmgmt.entity.Classes;
import com.schoolmgmt.entity.Grades;
import com.schoolmgmt.entity.Students;
import com.schoolmgmt.entity.Subjects;
import com.schoolmgmt.service.GradesService;

public class GradesServicesImpl implements GradesService{
	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertGrade(SessionFactory sf) {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		Grades grade = new Grades();
		System.out.println("Enter the grade value");
		String value= sc.next();
		grade.setGradeValue(value);
		System.out.println("Enter StudentId  for Grades:");
		int stuId = sc.nextInt();
		Students students = session.get(Students.class, stuId);

		System.out.println("Enter classId  for Grades:");
		int classId = sc.nextInt();
		Classes classes = session.get(Classes.class, classId);
		classes.getGrades().add(grade);
		System.out.println("Enter subId  for Grades:");
		int subId = sc.nextInt();
		Subjects subjects = session.get(Subjects.class, subId);
		subjects.getGrades().add(grade);
		grade.setStudents(students);
		grade.setClasses(classes);
		grade.setSubjects(subjects);
		session.persist(grade);
		session.saveOrUpdate(subjects);
		session.saveOrUpdate(classes);
		session.saveOrUpdate(students);
		transacation.commit();
		session.close();
	}

	
	public void updateGrade(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Grades grade;
		while (true) {
			System.out.println(
					"choose option for update \n  1.update student Id value \n 2.update classId \n 3.update subject Id \n  4.exit");
			int option = sc.nextInt();
			switch (option) {
			/*case 1:
				System.out.println("enter grade value:");
				grade = session.get(Grades.class, sc.next());
				session.saveOrUpdate(grade);
				transaction.commit();
				break;*/
			case 1:
				System.out.println("enter student Id:");
				int StuId = sc.nextInt();
				Students students = session.get(Students.class, StuId);
				System.out.println("enter grade value:");
				grade = session.get(Grades.class, sc.next());
				grade.setStudents(students);
				session.saveOrUpdate(grade);
				transaction.commit();
				break;
			case 2:
				System.out.println("enter grade value:");
				grade = session.get(Grades.class, sc.nextInt());
				System.out.println("enter class Id:");
				int ClassId = sc.nextInt();
				Classes classes = session.get(Classes.class, ClassId);
				//grade.getClasses().add(classes);
				grade.setClasses(classes);
				session.saveOrUpdate(grade);
				transaction.commit();
				break;
			case 3:
				System.out.println("enter grade value:");
				grade = session.get(Grades.class, sc.nextInt());
				System.out.println("enter subject Id:");
				int subId = sc.nextInt();
				Subjects subjects = session.get(Subjects.class, subId);
				//grade.getSubjects().add(subjects);
				grade.setSubjects(subjects);
				session.saveOrUpdate(grade);
				transaction.commit();
				break;
				
			case 4:
				System.out.println("exiting from update grade");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid option");
			}
		}
	}

	
	public void deleteGrade(SessionFactory sf) {
			session = sf.openSession();
			Transaction transacation = session.beginTransaction();
			System.out.println("enter grade value");
		 String value= sc.next();
			Grades grade = session.get(Grades.class, value);
			session.delete(grade);
			transacation.commit();
			session.close();
	}

	
	public void getAllGrade(SessionFactory sf) {
		session = sf.openSession();
		Query createQuery = session.createQuery("from Grades");
		  
	    List<Grades> resultList = createQuery.getResultList();
	    
	    for(Grades g:resultList)
	    	System.out.println(g);
	    session.close();
	}

	
	public void getGrade(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("enter grade value :");
		String value=sc.next();
		Grades grades=session.get(Grades.class,value);
		System.out.println(grades);
		session.close();

	}

}