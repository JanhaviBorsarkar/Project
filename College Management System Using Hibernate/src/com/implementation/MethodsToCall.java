package com.implementation;

import com.services.*;
import com.models.*;
import org.hibernate.Session;
import java.util.Scanner;

public class MethodsToCall implements Services
{
	Scanner sc = new Scanner(System.in);
	Session session = HibernateUtilCMS.getSessionFactory().openSession();
	Course course = null;
	Faculty faculty = null;
	Batch batch =null;
	Student student =null;
	
	// Methods for class course
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
	
	// methods for class faculty
	public void addFaculty()
	{
		faculty = new Faculty();
		System.out.println("Enter faculty id: ");
		faculty.setFid(sc.nextInt());
		System.out.println("Enter the faculty name: ");
		faculty.setFname(sc.next());
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
		System.out.println("Course id: " +faculty.getC().getCno());
		System.out.println("Course name: " +faculty.getC().getCname());
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

	//methods for class batch
	public void addBatch()
	{
		batch = new Batch();
		System.out.println("Enter batch id: ");
		batch.setBid(sc.nextInt());
		System.out.println("Enter batch name: ");
		batch.setBname(sc.next());
		System.out.println("Enter the faculty id that you want to assign: ");
		faculty = session.get(Faculty.class, sc.nextInt());
		batch.setF(faculty);
		session.save(batch);
		session.beginTransaction().commit();
		System.out.println("Batch details added successfully!!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void viewBatch()
	{
		System.out.println("Enter the batch id that you want to get details of: ");
		int view = sc.nextInt();
		batch = session.get(Batch.class, view);
		System.out.println("Batch id: " +batch.getBid());
		System.out.println("Batch name: " +batch.getBname());
		System.out.println("Faculty id: " +batch.getF().getFid());
		System.out.println("Faculty name: " +batch.getF().getFname());
		System.out.println("Course id: " +batch.getF().getC().getCno());
		System.out.println("Course name: " +batch.getF().getC().getCname());
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void updateBatch()
	{
		System.out.println("Enter the batch id that you want to update: ");
		int up = sc.nextInt();
		batch = session.get(Batch.class, up);
		System.out.println("The detials that you want to update are: \n Batch id: " +batch.getBid()+ "\n Batch name: " +batch.getBname());
		System.out.println("Enter the name you want to assign: ");
		batch.setBname(sc.next());
		session.update(batch);
		session.beginTransaction().commit();
		System.out.println("Batch details updated successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void deleteBatch()
	{
		System.out.println("Enter the batch id that you want to delete: ");
		int del = sc.nextInt();
		batch = session.get(Batch.class, del);
		System.out.println("The detials that you want to delete are: \n Batch id: " +batch.getBid()+ "\n Batch name: " +batch.getBname());
		session.delete(batch);
		session.beginTransaction().commit();
		System.out.println("Batch details removed successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");	
	}


	//methods for class Student
	public void addStudent()
	{
		student = new Student();
		System.out.println("Enter student rollno: ");
		student.setRno(sc.nextInt());
		System.out.println("Enter student name: ");
		student.setSname(sc.next());
		System.out.println("Enter the batch id that you want to assign: ");
		batch = session.get(Batch.class, sc.nextInt());
		student.setB(batch);
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Student details added successfully!!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void viewStudent()
	{
		System.out.println("Enter the roll number that you want to get details of: ");
		int view = sc.nextInt();
		student = session.get(Student.class, view);
		System.out.println("Roll number: " +student.getRno());
		System.out.println("Name: " +student.getSname());
		System.out.println("Batch id: " +student.getB().getBid());
		System.out.println("Batch name: " +student.getB().getBname());
		System.out.println("Faculty id: " +student.getB().getF().getFid());
		System.out.println("Faculty name: " +student.getB().getF().getFname());
		System.out.println("Course id: " +student.getB().getF().getC().getCno());
		System.out.println("Course name: " +student.getB().getF().getC().getCname());
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void updateStudent()
	{
		System.out.println("Enter the roll number that you want to update: ");
		int up = sc.nextInt();
		student = session.get(Student.class, up);
		System.out.println("The detials that you want to update are: \n  Roll number: " +student.getRno()+ "\n Name: " +student.getSname());
		System.out.println("Enter the name you want to assign: ");
		student.setSname(sc.next());
		session.update(student);
		session.beginTransaction().commit();
		System.out.println("Student details updated successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

	}
	
	public void deleteStudent()
	{
		System.out.println("Enter the roll number that you want to delete: ");
		int del = sc.nextInt();
		student = session.get(Student.class, del);
		System.out.println("The detials that you want to delete are: \n  Roll number: " +student.getRno()+ "\n Name: " +student.getSname());
		session.delete(student);
		session.beginTransaction().commit();
		System.out.println("Student details removed successfully!");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");	
	}
}
