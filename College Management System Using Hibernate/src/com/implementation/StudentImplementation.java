package com.implementation;

import java.util.Scanner;

import org.hibernate.Session;

import com.models.Batch;
import com.models.Student;

public class StudentImplementation 
{
	Scanner sc = new Scanner(System.in);
	Session session = HibernateUtilCMS.getSessionFactory().openSession();
	Student student = null;
	Batch batch = null;
	
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
		/*System.out.println("Batch id: " +student.getB().getBid());
		System.out.println("Batch name: " +student.getB().getBname());
		System.out.println("Faculty id: " +student.getB().getF().getFid());
		System.out.println("Faculty name: " +student.getB().getF().getFname());
		System.out.println("Course id: " +student.getB().getF().getC().getCno());
		System.out.println("Course name: " +student.getB().getF().getC().getCname());*/
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
