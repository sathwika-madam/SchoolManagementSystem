package com.schoolmgmt.service;

import java.text.ParseException;
import org.hibernate.SessionFactory;

public interface AttendanceService {
	
	void insertAttendance(SessionFactory sf) throws ParseException, com.google.protobuf.TextFormat.ParseException;

	void updateAttendance(SessionFactory sf);

	void deleteAttendance(SessionFactory sf);

	void getAllAttendance(SessionFactory sf);

	void getAttendance(SessionFactory sf);

}