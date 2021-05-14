package com.implementation;

import java.util.Scanner;
import org.hibernate.Session;
import com.models.Course;

public class CourseImplementation 
{
	Scanner sc = new Scanner(System.in);
	Session session = HibernateUtilCMS.getSessionFactory().openSession();
	Course course = null;
	
	public void addCourse() 
	{
		course = new Course();
		System.out.println("Enter course id: ");
		course.setCno(sc.nextInt());
		System.out.println("Enter the course name: ");
		course.setCname(sc.next());
		session.save(course);
		session.beginTransaction().commit();
		System.out.println("Course details added successfully!!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void viewCourse()
	{
		System.out.println("Enter the course id that you want to get details of: ");
		int view = sc.nextInt();
		course = session.get(Course.class, view);
		System.out.println("Course id: " +course.getCno());
		System.out.println("Course name: " +course.getCname());
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void updateCourse()
	{
		System.out.println("Enter the course id that you want to update: ");
		int up = sc.nextInt();
		course = session.get(Course.class, up);
		System.out.println("The detials that you want to update are: \n Course id: " +course.getCno()+ "\n Course name: " +course.getCname());
		System.out.println("Enter the name you want to assign: ");
		course.setCname(sc.next());
		session.update(course);
		session.beginTransaction().commit();
		System.out.println("Course details updated successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void deleteCourse()
	{
		System.out.println("Enter the course id that you want to delete: ");
		int del = sc.nextInt();
		course = session.get(Course.class, del);
		System.out.println("The detials that you want to delete are: \n Course id: " +course.getCno()+ "\n Course name: " +course.getCname());
		session.delete(course);
		session.beginTransaction().commit();
		System.out.println("Course details removed successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
}
