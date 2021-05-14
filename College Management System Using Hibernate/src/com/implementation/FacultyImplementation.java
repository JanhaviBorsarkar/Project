package com.implementation;

import java.util.Scanner;
import org.hibernate.Session;
import com.models.Course;
import com.models.Faculty;

public class FacultyImplementation 
{
	Scanner sc = new Scanner(System.in);
	Session session = HibernateUtilCMS.getSessionFactory().openSession();
	Faculty faculty = null;
	Course course = null;

	public void addFaculty()
	{
		faculty = new Faculty();
		System.out.println("Enter faculty id: ");
		faculty.setFid(sc.nextInt());
		System.out.println("Enter the faculty name: ");
		faculty.setFname(sc.next());
		course = new Course();
		System.out.println("Enter the course id that you want to assign: ");
		course = session.get(Course.class, sc.nextInt());
		faculty.setC(course);
		session.saveOrUpdate(faculty);
		session.beginTransaction().commit();
		System.out.println("Faculty details added successfully!!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");	
	}
	
	public void viewFaculty()
	{
		System.out.println("Enter the faculty id that you want to get details of: ");
		int view = sc.nextInt();
		faculty = session.get(Faculty.class, view);
		System.out.println("Faculty id: " +faculty.getFid());
		System.out.println("Faculty name: " +faculty.getFname());
		/*System.out.println("Course id: " +faculty.getC().getCno());
		System.out.println("Course name: " +faculty.getC().getCname());*/
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void updateFaculty()
	{
		System.out.println("Enter the faculty id that you want to update: ");
		int up = sc.nextInt();
		faculty = session.get(Faculty.class, up);
		System.out.println("The detials that you want to update are: \n Faculty id: " +faculty.getFid()+ "\n Faculty name: " +faculty.getFname());
		System.out.println("Enter the name you want to assign: ");
		faculty.setFname(sc.next());
		session.update(faculty);
		session.beginTransaction().commit();
		System.out.println("Faculty details updated successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void deleteFaculty()
	{
		System.out.println("Enter the faculty id that you want to delete: ");
		int del = sc.nextInt();
		faculty = session.get(Faculty.class, del);
		System.out.println("The detials that you want to delete are: \n Faculty id: " +faculty.getFid()+ "\n Faculty name: " +faculty.getFname());
		session.delete(faculty);
		session.beginTransaction().commit();
		System.out.println("Faculty details removed successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");	
	}

}
