package com.schoolmgmt.main;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.google.protobuf.TextFormat.ParseException;
import com.schoolmgmt.serviceImpl.AttendanceServiceImpl;
import com.schoolmgmt.serviceImpl.ClassesServiceImpl;
import com.schoolmgmt.serviceImpl.GradesServicesImpl;
import com.schoolmgmt.serviceImpl.ParentsServiceImpl;
import com.schoolmgmt.serviceImpl.StudentServiceImpl;
import com.schoolmgmt.serviceImpl.SubjectServiceImpl;
import com.schoolmgmt.serviceImpl.TeacherServiceImpl;
import com.schoolmgmt.utility.ConfigurationUtility;

public class SchoolManagementMain {

	public static void main(String[] args) throws ParseException, java.text.ParseException {
		SessionFactory getsFactory = ConfigurationUtility.getsFactory();

		Scanner sc = new Scanner(System.in);
		ClassesServiceImpl classService = new ClassesServiceImpl();
		StudentServiceImpl studentService = new StudentServiceImpl();
		SubjectServiceImpl subjectService = new SubjectServiceImpl();
		AttendanceServiceImpl attendanceService = new AttendanceServiceImpl();
		GradesServicesImpl gradeService = new GradesServicesImpl();
		ParentsServiceImpl parentService = new ParentsServiceImpl();
		TeacherServiceImpl teacherService = new TeacherServiceImpl();

		// SessionFactory getsFactory=null;
		try {
			while (true) {
				System.out.println("\nEnter your Option:");
				System.out.println(
						"1. Classes Services \n 2. Students Services \n 3. Subjects Services \n 4. Attendance Services"
								+ " \n5. Grades Services \n6. Parents Services \n7. Teachers Services \n8. Exit");
				int mainOption = sc.nextInt();
				switch (mainOption) {
				case 1: // Classes options
					while (true) {

						System.out.println("1. Insert Class \n2. Update Class \n3. Delete Class \n4. Get All Class "
								+ "\n5. Get Class \n6. Return to Main Menu");
						int classoption = sc.nextInt();
						switch (classoption) {
						case 1:
							classService.insertClasses(getsFactory);
							break;
						case 2:
							classService.updateClasses(getsFactory);
							break;
						case 3:
							classService.deleteClasses(getsFactory);
							break;
						case 4:
							classService.getAllClasses(getsFactory);
							break;
						case 5:
							classService.getClasses(getsFactory);
							break;
						case 6:
							System.out.println("Returning to Main Menu");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
						}
						if (classoption == 6)
							break; // Exit to main menu if selected
					}
					break;

				case 2: // Students options
					while (true) {
						System.out.println(
								"1. Insert Student \n2. Update Student \n3. Delete Student \n4. Get All Student \n5. Get Student \n6. Return to Main Menu");
						int studentoption = sc.nextInt();
						switch (studentoption) {
						case 1:
							studentService.insertStudent(getsFactory);
							break;
						case 2:
							studentService.updateStudent(getsFactory);
							break;
						case 3:
							studentService.deleteStudent(getsFactory);
							break;
						case 4:
							studentService.getAllStudent(getsFactory);
							break;
						case 5:
							studentService.getstudent(getsFactory);
							break;
						case 6:
							System.out.println("Returning to Main Menu");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
						}
						if (studentoption == 6)
							break; // Exit to main menu if selected
					}
					break;

				case 3: // Subjects options
					while (true) {
						System.out.println(
								"1. Insert Subject \n2. Update Subject \n3. Delete Subject \n4. Get All Subject \n5. Get Subject \n6. Return to Main Menu");
						int subjectoption = sc.nextInt();
						switch (subjectoption) {
						case 1:
							subjectService.insertSubject(getsFactory);
							break;
						case 2:
							subjectService.updateSubject(getsFactory);
							break;
						case 3:
							subjectService.deleteSubject(getsFactory);
							break;
						case 4:
							subjectService.getAllSubjects(getsFactory);
							break;
						case 5:
							subjectService.getSubject(getsFactory);
							break;
						case 6:
							System.out.println("Returning to Main Menu");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
						}
						if (subjectoption == 6)
							break; // Exit to main menu if selected
					}
					break;

				case 4: // Attendance options
					while (true) {
						System.out.println(
								"1. Insert Attendance \n2. Update Attendance \n3. Delete Attendance \n4. Get All Attendance \n5. Get Attendance \n6. Return to Main Menu");
						int attendanceoption = sc.nextInt();
						switch (attendanceoption) {
						case 1:
							attendanceService.insertAttendance(getsFactory);
							break;
						case 2:
							attendanceService.updateAttendance(getsFactory);
							break;
						case 3:
							attendanceService.deleteAttendance(getsFactory);
							break;
						case 4:
							attendanceService.getAllAttendance(getsFactory);
							break;
						case 5:
							attendanceService.getAttendance(getsFactory);
							break;
						case 6:
							System.out.println("Returning to Main Menu");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
						}
						if (attendanceoption == 6)
							break; // Exit to main menu if selected
					}
					break;

				case 5: // Grade options
					while (true) {
						System.out.println(
								"1. Insert Grade \\n2. Update Grade \\n3. Delete Grade \\n4. Get All Grade \\n5. Get Grade\n6. Return to Main Menu");
						int gradeoption = sc.nextInt();
						switch (gradeoption) {
						case 1:
							gradeService.insertGrade(getsFactory);
							break;
						case 2:
							gradeService.updateGrade(getsFactory);
							break;
						case 3:
							gradeService.deleteGrade(getsFactory);
							break;
						case 4:
							gradeService.getAllGrade(getsFactory);
							break;
						case 5:
							gradeService.getGrade(getsFactory);
							break;
						case 6:
							System.out.println("Returning to Main Menu");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
						}
						if (gradeoption == 6)
							break; // Exit to main menu if selected
					}
					break;

				case 6: // Parents options
					while (true) {
						System.out.println(
								"1. Insert Parent \\n2. Update Parent \\n3. Delete Parent \\n4. Get All Parent \\n5. Get Parent\n6. Return to Main Menu");
						int parentsoptions = sc.nextInt();
						switch (parentsoptions) {
						case 1:
							parentService.insertParent(getsFactory);
							break;
						case 2:
							parentService.updateParent(getsFactory);
							break;
						case 3:
							parentService.deleteParent(getsFactory);
							break;
						case 4:
							parentService.getAllParent(getsFactory);
							break;
						case 5:
							parentService.getParent(getsFactory);
							break;
						case 6:
							System.out.println("Returning to Main Menu");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
						}
						if (parentsoptions == 6)
							break; // Exit to main menu if selected
					}
					break;
				case 7: // Teachers options
					while (true) {
						System.out.println(
								"1. Insert Teacher \n2. Update Teacher \n3. Delete Teacher \n4. Get All Teachers \n5. Get Teacher \n6. Return to Main Menu");
						int teacheroption = sc.nextInt();
						switch (teacheroption) {
						case 1:
							teacherService.insertTeacher(getsFactory);
							break;
						case 2:
							teacherService.updateTeacher(getsFactory);
							break;
						case 3:
							teacherService.deleteTeacher(getsFactory);
							break;
						case 4:
							teacherService.getAllTeacher(getsFactory);
							break;
						case 5:
							teacherService.getTeacher(getsFactory);
							break;
						case 6:
							System.out.println("Returning to Main Menu");
							break;
						default:
							System.out.println("Invalid option. Please try again.");
							break;
						}
						if (teacheroption == 6)
							break; // Exit to main menu if selected
					}
					break;

				case 8:
					System.out.println("Exiting");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid category. Please try again.");
					break;
				}
			}
		} finally {
			// Ensure resources are closed
			if (getsFactory != null) {
				getsFactory.close();
			}
			sc.close();
		}
	}
}