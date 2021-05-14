package com.braindatawire.collegemanagement.serviceImpl;

import com.braindatawire.collegemanagement.model.*;
import com.braindatawire.collegemanagement.service.Cjc;
import java.util.*;

public class KarveNagar implements Cjc 
{
	List<Course> clist=new ArrayList<>();
	List<Faculty> flist=new ArrayList<>();
	List<Batch> blist=new ArrayList<>();
	List<Student> slist=new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	int count = 0;
	int count1 = 0;
	int count2 = 0;

	// Setting course details
	public void addCourse() 
	{
		Course c = new Course();
		System.out.println("Enter Course id: ");
		c.setCid(sc.nextInt());
		System.out.println("Enter Course Name: ");
		c.setCname(sc.next());
		clist.add(c);
		count++; //1
	}

	//Getting course details
	public void viewCourse() 
	{
		if(count > 0)
		{
			Iterator<Course> itr=clist.iterator();
			while(itr.hasNext()) 
			{
				System.out.println("\n");
				Course c1= itr.next();
				System.out.println("Course id: " +c1.getCid());
				System.out.println("Course name: " +c1.getCname());
			}
			System.out.println("End of Course details");
			System.out.println("\n");
		}
		else
		{
			System.out.println("Enter the course details first");
		}
	}

	//Setting faculty details
	public void addFaculty() 
	{
		if(count>0)
		{
			Faculty f = new Faculty();
			System.out.println("Enter faculty id: ");
			f.setFid(sc.nextInt());
			System.out.println("Enter faculty name: ");
			f.setFname(sc.next());
			Iterator<Course> itr = clist.iterator();
			while(itr.hasNext())
			{
				Course c1 = itr.next();
				f.setCourse(c1);
			}
			flist.add(f);
			count1++;
		}
		else 
		{
			System.out.println("Please add course details first");
		}
	}
	
	//Getting faculty details
	public void viewFaculty() 
	{
		if(count1 > 0)
		{
			Iterator<Faculty> itr=flist.iterator();
		while(itr.hasNext()) 
		{
			System.out.println("\n");
			Faculty f = itr.next();
			System.out.println("Course id: " +f.getCourse().getCid());
			System.out.println("Course name: " +f.getCourse().getCname());
			System.out.println("Faculty id: " +f.getFid());
			System.out.println("Faculty name: " +f.getFname());
		}
		System.out.println("End of faculty details");
		System.out.println("\n");
		}
		else
		{
			System.out.println("Enter faculty details first");
		}
	}

	//Setting batch details
	public void addBatch() 
	{
		if(count1 > 0)
		{
			Batch b = new Batch();
			System.out.println("Enter batch id: ");
			b.setBid(sc.nextInt());
			System.out.println("Enter batch name: ");
			b.setBname(sc.next());
			Iterator<Faculty> itr = flist.iterator();
			while(itr.hasNext())
			{
				Faculty f = itr.next();
				b.setFaculty(f);
			}
			blist.add(b);
			count2++;
		}
		else
		{
			System.out.println("Please enter faculty details first");
		}
	}

	//Getting batch details
	public void viewBatch() 
	{
		if(count2>0)
		{
		Iterator<Batch> itr = blist.iterator();
		while(itr.hasNext())
		{
			System.out.println("\n");
			Batch b = itr.next();
			System.out.println("Course id: " +b.getFaculty().getCourse().getCid());
			System.out.println("Course name: " +b.getFaculty().getCourse().getCname());
			System.out.println("Faculty id: " +b.getFaculty().getFid());
			System.out.println("Faculty name: " +b.getFaculty().getFname());
			System.out.println("Batch id: " +b.getBid());
			System.out.println("Batch name: " +b.getBname());
		}
		System.out.println("End of batch details");
		System.out.println("\n");
		}
		else
		{
			System.out.println("Please enter batch details first");
		}
	}

	//Setting student details
	public void addStudent() 
	{
		if(count2 > 0)
		{
			Student s = new Student();
			System.out.println("Enter student id: ");
			s.setSid(sc.nextInt());
			System.out.println("Enter student name: ");
			s.setSname(sc.next());
			Iterator<Batch> itr = blist.iterator();
			while(itr.hasNext())
			{
				Batch b = itr.next();
				s.setBatch(b);
			}
			slist.add(s);
		}
		else
		{
			System.out.println("Enter batch details first");
		}
	}

	//Getting Student details
	public void viewStudent() 
	{
		Iterator<Student> itr = slist.iterator();
		while(itr.hasNext())
		{
			System.out.println("\n");
			Student s = itr.next();
			System.out.println("Course id: " +s.getBatch().getFaculty().getCourse().getCid());
			System.out.println("Course name: " +s.getBatch().getFaculty().getCourse().getCname());
			System.out.println("Faculty id: " +s.getBatch().getFaculty().getFid());
			System.out.println("Faculty name: " +s.getBatch().getFaculty().getFname());
			System.out.println("Batch id: " +s.getBatch().getBid());
			System.out.println("Batch name: " +s.getBatch().getBname());
			System.out.println("Student id: " +s.getSid());
			System.out.println("Student name: " +s.getSname());
		}
		System.out.println("End of student details");
		System.out.println("\n");
	}
}
