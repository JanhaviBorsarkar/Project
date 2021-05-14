package com.braindatawire.collegemanagement.client;

import java.util.*;
import com.braindatawire.collegemanagement.client.*;
import com.braindatawire.collegemanagement.model.*;
import com.braindatawire.collegemanagement.service.*;
import com.braindatawire.collegemanagement.serviceImpl.*;

public class Test 
{
	public static void main(String[] args) 
	{
		Cjc k = new KarveNagar();
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(true)
		{
			System.out.println("Please select one of the following operations to move forward");
			System.out.println("\n");
			System.out.println("1. Add Course Details");
			System.out.println("2. View Course Details");
			System.out.println("3. Add Faculty Details");
			System.out.println("4. View Faculty Details");
			System.out.println("5. Add Batch Details");
			System.out.println("6. View Batch Details");
			System.out.println("7. Add Student Details");
			System.out.println("8. View Student Details");
			System.out.println("9. Exit");
		
			int choice = sc.nextInt();
		
			switch(choice)
			{
				case 1: 
					k.addCourse();
					break;
		
				case 2:
					k.viewCourse();
					break;
		
				case 3:
					k.addFaculty();
					break;
		
				case 4:
					k.viewFaculty();
					break;
					
				case 5:
					k.addBatch();
					break;
		
				case 6:
					k.viewBatch();
					break;
		
				case 7:
					k.addStudent();
					break;
	
				case 8:
					k.viewStudent();
					break;
		
				case 9:
					System.out.println("Thank you for using this system!");
					System.exit(0);
		
				default:
					System.out.println("Invalid Selection");
			}
		}
	}
}