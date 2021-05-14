package com.implementation;

import java.util.Scanner;
import org.hibernate.Session;
import com.models.Batch;
import com.models.Faculty;

public class BatchImplementation 
{
	Scanner sc = new Scanner(System.in);
	Session session = HibernateUtilCMS.getSessionFactory().openSession();
	Batch batch = null;
	Faculty faculty = null;
	
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
		/*System.out.println("Faculty id: " +batch.getF().getFid());
		System.out.println("Faculty name: " +batch.getF().getFname());
		System.out.println("Course id: " +batch.getF().getC().getCno());
		System.out.println("Course name: " +batch.getF().getC().getCname());*/
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

}
