package com.schoolmgmt.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.schoolmgmt.entity.Classes;
import com.schoolmgmt.entity.Students;
import com.schoolmgmt.service.StudentService;

public class StudentServiceImpl implements StudentService {
	Session session;
	Scanner sc = new Scanner(System.in);
	
	public void insertStudent(SessionFactory sf) throws ParseException,java.text.ParseException {
		session=sf.openSession();
		Transaction transaction=session.beginTransaction();	
		Classes classes=new Classes();
		Students students=new Students();
		System.out.println("Enter Student id:");
		int stuId=sc.nextInt();
		students.setStuId(stuId);
		System.out.println("Enter student name:");
		String name=sc.next();
		students.setName(name);
		System.out.println("Enter phone number:");
		Long phno=sc.nextLong();
		students.setPhno(phno);
		System.out.println("Enter email address:");
		String email=sc.next();
		students.setEmail(email);
		System.out.println("Enter student address:");
		String address=sc.next();
		students.setAddress(address);
		
		System.out.println("Enter date of birth");
		String input = sc.next();
		LocalDate date2=LocalDate.parse(input);
		students.setDOB(date2);

		/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		date = formatter.parse(input);
		System.out.println("Parsed Date: " + date);*/
		
		System.out.println("Enter student enroll date:");
		String input1= sc.next();
		LocalDate date3=LocalDate.parse(input1);
		students.setEnrollDate(date3);

		/*String input1 = sc.nextLine();
		SimpleDateFormat formatters = new SimpleDateFormat("dd/MM/yyyy");
		Date date1;
		date1 = formatters.parse(input1);
		System.out.println("Parsed Date: " + date1);*/
		System.out.println("Enter classId  for students:");
		int classId = sc.nextInt();
		Classes class1 = session.get(Classes.class, classId);
		session.saveOrUpdate(class1);
		session.persist(students);
		transaction.commit();
		session.close();		
	}		
	public void updateStudent(SessionFactory sf) {
		session=sf.openSession();
		Transaction transaction=session.beginTransaction();	
		Students students;
		
		while (true) {
			System.out.println("choose option for update: \n1.update StudentName \n2.update student DOB \n3.update student phnno "
					+ "\4.update student email \n4.update student address\n5.Exit");
			
			int option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter studentId:");
				students=session.get(Students.class,sc.nextInt());
				System.out.println("Enter StudentName to update:");
				students=session.get(Students.class,sc.next());
				session.saveOrUpdate(students);
				transaction.commit();
				break;
			case 2:
				System.out.println("Enter studentId:");
				students=session.get(Students.class,sc.nextInt());
				System.out.println("Enter Student DOB to update:");
				students=session.get(Students.class,sc.next());
				session.saveOrUpdate(students);
				transaction.commit();
				break;
			case 3:	
				System.out.println("Enter studentId:");
				students=session.get(Students.class,sc.nextInt());
				System.out.println("Enter Student phNo to update:");
				students=session.get(Students.class,sc.next());
				session.saveOrUpdate(students);
				transaction.commit();
				break;
			case 4:
				System.out.println("Enter studentId:");
				students=session.get(Students.class,sc.nextInt());
				System.out.println("Enter Student Email to update:");
				students=session.get(Students.class,sc.next());
				session.saveOrUpdate(students);
				transaction.commit();
				break;
			case 5:
				System.out.println("Enter studentId:");
				students=session.get(Students.class,sc.nextInt());
				System.out.println("Enter Student Adress to update:");
				students=session.get(Students.class,sc.next());
				session.saveOrUpdate(students);
				transaction.commit();
				break;
			case 6:
				System.out.println("existing from update grade:");
				System.exit(0);
				break;
			default:
				System.out.println("enter valid option");	
			}
		}		
	}

	
	public void deleteStudent(SessionFactory sf) {
		session=sf.openSession();
		Transaction transaction=session.beginTransaction();	
		
		System.out.println("Enter StudentId:");
		int id=sc.nextInt();
		Students grade=session.get(Students.class,id);
		session.delete(grade);
		transaction.commit();
		session.close();	
		
	}

	
	public void getAllStudent(SessionFactory sf) {
session=sf.openSession();
		
		Query query=session.createQuery("from Students");
		List<Students> resultList=query.getResultList();
		
		for(Students stu:resultList)
			System.out.println(stu);
		
		session.close();
		
	}		

	
	public void getstudent(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("enter student id:");
		int StuId=sc.nextInt();
		Students student=session.get(Students.class,StuId);
		System.out.println(student);
		session.close();
	}


}