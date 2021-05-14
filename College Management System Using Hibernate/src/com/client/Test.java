package com.client;

import com.models.*;
import com.implementation.*;
import java.util.Scanner;

public class Test 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		CourseImplementation ci = new CourseImplementation();
		FacultyImplementation fi = new FacultyImplementation();
		BatchImplementation bi = new BatchImplementation();
		StudentImplementation si = new StudentImplementation();
		
		boolean flag = true;
		while(true)
		{
			System.out.println("Please select one of the following to move forward");
			System.out.println("\n");
			System.out.println("1. Student");
			System.out.println("2. Batch");
			System.out.println("3. Faculty");
			System.out.println("4. Course");
			System.out.println("5. Exit");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
			
			int choice = sc.nextInt();
			boolean flag1 = true;
			while(true)
			{
				switch(choice)
				{
					case 1: // student
						System.out.println("Please select one of the following operations to move forward");
						System.out.println("\n");
						System.out.println("1. Add Student Details");
						System.out.println("2. View Student Details");
						System.out.println("3. Update Student Details");
						System.out.println("4. Delete Student Details");
						System.out.println("5. Exit");
					
						int choice1 = sc.nextInt();
						switch(choice1)
						{
							case 1:
								si.addStudent();
								break;
							case 2:
								si.viewStudent();
								break;
							case 3:
								si.updateStudent();
								break;
							case 4:
								si.deleteStudent();
								break;
							case 5:
								System.out.println("Thank you!!");
								System.exit(0);	
							default:
								System.out.println("Invalid Selection");
						}
					case 2: //batch
						System.out.println("Please select one of the following operations to move forward");
						System.out.println("\n");
						System.out.println("1. Add Batch Details");
						System.out.println("2. View Batch Details");
						System.out.println("3. Update Batch Details");
						System.out.println("4. Delete Batch Details");
						System.out.println("5. Exit");
					
						int choice2 = sc.nextInt();
						switch(choice2)
						{
							case 1:
								bi.addBatch();
								break;
							case 2:
								bi.viewBatch();
								break;
							case 3:
								bi.updateBatch();
								break;
							case 4:
								bi.deleteBatch();
								break;
							case 5:
								System.out.println("Thank you!!");
								System.exit(0);	
							default:
								System.out.println("Invalid Selection");
						}
					case 3: //faculty
						System.out.println("Please select one of the following operations to move forward");
						System.out.println("\n");
						System.out.println("1. Add Faculty Details");
						System.out.println("2. View Faculty Details");
						System.out.println("3. Update Faculty Details");
						System.out.println("4. Delete Faculty Details");
						System.out.println("5. Exit");
					
						int choice3 = sc.nextInt();
						switch(choice3)
						{
							case 1:
								fi.addFaculty();
								break;
							case 2:
								fi.viewFaculty();
								break;
							case 3:
								fi.updateFaculty();
								break;
							case 4:
								fi.deleteFaculty();
								break;
							case 5:
								System.out.println("Thank you!!");
								System.exit(0);	
							default:
								System.out.println("Invalid Selection");
						}
					case 4: //course
						System.out.println("Please select one of the following operations to move forward");
						System.out.println("\n");
						System.out.println("1. Add Course Details");
						System.out.println("2. View Course Details");
						System.out.println("3. Update Course Details");
						System.out.println("4. Delete Course Details");
						System.out.println("5. Exit");
					
						int choice4 = sc.nextInt();
						switch(choice4)
						{
							case 1:
								ci.addCourse();
								break;
							case 2:
								ci.viewCourse();
								break;
							case 3:
								ci.updateCourse();
								break;
							case 4:
								ci.deleteCourse();
								break;
							case 5:
								System.out.println("Thank you!!");
								System.exit(0);	
							default:
								System.out.println("Invalid Selection");
						}
					case 5:
						System.out.println("Thank you!!");
						System.exit(0);	
					default:
						System.out.println("Invalid Selection");		
				}
			}
		}
	}
}
