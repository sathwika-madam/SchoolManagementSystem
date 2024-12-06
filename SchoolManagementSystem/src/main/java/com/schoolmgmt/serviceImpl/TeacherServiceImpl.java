package com.schoolmgmt.serviceImpl;

import java.util.List;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.schoolmgmt.entity.Grades;
import com.schoolmgmt.entity.Subjects;
import com.schoolmgmt.entity.Teachers;
import com.schoolmgmt.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertTeacher(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Teachers teachers = new Teachers();
		System.out.println("Enter Teacher Details: \nTeacher Id:");
		teachers.setTeacherId(sc.nextInt());
		System.out.println("Teacher Name:");
		teachers.setTeacherName(sc.next());
		System.out.println("Teacher Email:");
		teachers.setEmail(sc.next());
		System.out.println("Teacher Phno:");
		teachers.setPhno(sc.nextLong());
		System.out.println("Enter subjectId for Teacher:");
		int subId = sc.nextInt();
		Subjects subjects = session.get(Subjects.class, subId);
		session.persist(teachers);
		session.saveOrUpdate(subjects);
	}

	public void updateTeacher(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Teachers teachers;
		while (true) {
			System.out.println(
					"choose option for update \n 1.update name\n 2.update Teacher phno \n 3.update email\n 4.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("enter teacher id:");
				teachers = session.get(Teachers.class, sc.nextInt());
				System.out.println("enter teacher name:");
				teachers = session.get(Teachers.class, sc.next());
				session.saveOrUpdate(teachers);
				transaction.commit();
				break;
			case 2:
				System.out.println("enter teacher id:");
				teachers = session.get(Teachers.class, sc.nextInt());
				System.out.println("enter Teacher phno:");
				teachers = session.get(Teachers.class, sc.nextLong());
				session.saveOrUpdate(teachers);
				transaction.commit();
				break;
			case 3:
				System.out.println("enter teacher id:");
				teachers = session.get(Teachers.class, sc.nextInt());
				System.out.println("enter student email:");
				teachers = session.get(Teachers.class, sc.next());
				session.saveOrUpdate(teachers);
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

	public void deleteTeacher(SessionFactory sf) {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		System.out.println("enter TeacherId");
		int TeacherId = sc.nextInt();
		Teachers teachers = session.get(Teachers.class, TeacherId);
		session.delete(teachers);
		transacation.commit();
		session.close();
	}

	public void getAllTeacher(SessionFactory sf) {
		session = sf.openSession();
		Query createQuery = session.createQuery("from Teachers");
		  
	    List<Teachers> resultList = createQuery.getResultList();
	    
	    for(Teachers t:resultList)
	    	System.out.println(t);
	    session.close();
	}

	
	public void getTeacher(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("enter TeacherId:");
		int teacherId=sc.nextInt();
		Teachers t=session.get(Teachers.class,teacherId);
		System.out.println(t);
		session.close();
	}

}