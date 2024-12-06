package com.schoolmgmt.serviceImpl;


import java.text.SimpleDateFormat;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.google.protobuf.TextFormat.ParseException;
import com.schoolmgmt.entity.Attendance;
import com.schoolmgmt.entity.Classes;
import com.schoolmgmt.entity.Grades;
import com.schoolmgmt.entity.Students;
import com.schoolmgmt.entity.Subjects;
import com.schoolmgmt.service.AttendanceService;

public class AttendanceServiceImpl implements AttendanceService {
	Session session;
	Scanner sc = new Scanner(System.in);

	public void insertAttendance(SessionFactory sf) throws ParseException, java.text.ParseException {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		Attendance attendance = new Attendance();
		
		System.out.println("Enter StudentId  for Attendance:");
		int stuId=sc.nextInt();
		Students students = session.get(Students.class, stuId);
		System.out.println("Enter a date (yyyy-mm-dd):");
		String input = sc.next();
		LocalDate date1=LocalDate.parse(input);
		System.out.println("Enter the status");
		String status = sc.next();
		System.out.println("Enter classId  for Attendance:");
		int classId = sc.nextInt();
		Classes classes = session.get(Classes.class, classId);
	
		attendance.setStatus(status);
		attendance.setDate(date1);
		attendance.setClasses(classes);
		attendance.setStudents(students);
		session.persist(attendance);
		session.save(students);
		session.saveOrUpdate(students);
		session.saveOrUpdate(classes);
		transacation.commit();
		session.close();
		/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		date = formatter.parse(input); // Parse the date
		System.out.println("Parsed Date: " + date);*/
	}

	public void updateAttendance(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Attendance attendance;
		Students students;
		while (true) {
			System.out.println(
					"choose option for update \n 1.update status \n 2.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("enter student id:");
				students = session.get(Students.class, sc.nextInt());
				System.out.println("enter student status:");
				attendance = session.get(Attendance.class, sc.next());
				attendance.setStudents(students);
				session.saveOrUpdate(attendance);
				transaction.commit();
				break;
			case 2:
				System.out.println("exiting from update grade");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid option");
			}
		}


	}

	public void deleteAttendance(SessionFactory sf) {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		System.out.println("enter status");
		String status = sc.next();
		Attendance attendance = session.get(Attendance.class, status);
		session.delete(attendance);
		transacation.commit();
		session.close();
	}

	public void getAllAttendance(SessionFactory sf) {
		session = sf.openSession();
		Query createQuery = session.createQuery("from Attendance");

		List<Attendance> resultList = createQuery.getResultList();

		for (Attendance att : resultList)
			System.out.println(att);
		session.close();
	}

	public void getAttendance(SessionFactory sf) {
		session = sf.openSession();

		Query query = session.createQuery("select count(status) from Attendance");
		List<String> list = query.list();
		System.out.println("Total status in School: " + list.get(0));
		session.close();
	}

}