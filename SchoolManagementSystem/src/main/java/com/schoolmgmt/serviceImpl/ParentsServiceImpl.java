package com.schoolmgmt.serviceImpl;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.schoolmgmt.entity.Classes;
import com.schoolmgmt.entity.Parents;
import com.schoolmgmt.entity.Students;
import com.schoolmgmt.service.ParentsService;

public class ParentsServiceImpl implements ParentsService {
	Session session;
	Scanner sc = new Scanner(System.in);

	public void insertParent(SessionFactory sf) {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		Parents parents = new Parents();
		Students students = new Students();
		System.out.println("Enter the name of parent");
		String name = sc.next();
		parents.setParentName(name);
		System.out.println("Enter the phone number of parent");
		Long phno = sc.nextLong();
		parents.setParentPhNo(phno);
		System.out.println("Enter the email of parent");
		String email = sc.next();
		parents.setEmail(email);
		System.out.println("Enter stuId  for parents:");
		int stuId = sc.nextInt();
		Students student = session.get(Students.class, stuId);
		parents.setStudents(students);
		session.persist(parents);
		session.saveOrUpdate(student);
		transacation.commit();
		session.close();
	}

	public void updateParent(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Parents parents;
		Students students;
		while (true) {
			System.out.println("choose option for update \n 1.update name\n 2.update email \n 3.update phno\n 4.exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("enter student id:");
				students = session.get(Students.class, sc.nextInt());
				System.out.println("enter new parent name :");
				parents = session.get(Parents.class, sc.next());
				session.saveOrUpdate(parents);
				transaction.commit();
				break;
			case 2:
				System.out.println("enter student id:");
				students = session.get(Students.class, sc.nextInt());
				System.out.println("enter new email Id:");
				String email = sc.next();
				parents = session.get(Parents.class, sc.next());
				session.saveOrUpdate(parents);
				transaction.commit();
				break;
			case 3:
				System.out.println("enter student id:");
				students = session.get(Students.class, sc.nextInt());
				System.out.println("enter phnone number :");
				Long ph = sc.nextLong();
				parents = session.get(Parents.class, sc.nextLong());
				session.saveOrUpdate(parents);
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

	public void deleteParent(SessionFactory sf) {
		session = sf.openSession();
		Transaction transacation = session.beginTransaction();
		System.out.println("enter parent name");
		String name = sc.next();
		Parents parents = session.get(Parents.class, name);
		session.delete(parents);
		transacation.commit();
		session.close();
	}

	public void getAllParent(SessionFactory sf) {
		session = sf.openSession();
		Query createQuery = session.createQuery("from Parents");

		List<Parents> resultList = createQuery.getResultList();

		for (Parents p : resultList)
			System.out.println(p);
		session.close();
	}

	public void getParent(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("enter parent name:");
		String name = sc.next();
		Parents parents = session.get(Parents.class, name);
		System.out.println(parents);
		session.close();
	}

}