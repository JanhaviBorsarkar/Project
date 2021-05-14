package com.client;

import java.util.Scanner;
import com.implementation.*;

public class TestAllInOne 
{
	public static void main(String[] args) 
	{
		MethodsToCall m = new MethodsToCall();
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while(true)
		{
			System.out.println("Please select one of the following operations to move forward");
			System.out.println("\n");
			System.out.println("1. Add Student Details");
			System.out.println("2. View Student Details");
			System.out.println("3. Update Student Details");
			System.out.println("4. Delete Student Details");
			System.out.println("5. Add Batch Details");
			System.out.println("6. View Batch Details");
			System.out.println("7. Update Batch Details");
			System.out.println("8. Delete Batch Details");
			System.out.println("9. Add Faculty Details");
			System.out.println("10. View Faculty Details");
			System.out.println("11. Update Faculty Details");
			System.out.println("12. Delete Faculty Details");
			System.out.println("13. Add Course Details");
			System.out.println("14. View Course Details");
			System.out.println("15. Update Course Details");
			System.out.println("16. Delete Course Details");
			System.out.println("17. Exit");
			 int choice = sc.nextInt();
			 
			 switch(choice)
			 {
			 	case 1:
			 		m.addStudent();
			 		break;
			 		
			 	case 2:
			 		m.viewStudent();
			 		break;
			 		
			 	case 3:
			 		m.updateStudent();
			 		break;
			 	
			 	case 4:
			 		m.deleteStudent();
			 		break;
			 		
			 	case 5:
			 		m.addBatch();
			 		break;
			 		
			 	case 6:
			 		m.viewBatch();
			 		break;
			 		
			 	case 7:
			 		m.updateBatch();
			 		break;
			 		
			 	case 8:
			 		m.deleteBatch();
			 		break;
			 		
			 	case 9:
			 		m.addFaculty();
			 		break;
			 		
			 	case 10:
			 		m.viewFaculty();
			 		break;
			 		
			 	case 11:
			 		m.updateFaculty();
			 		break;
			 		
			 	case 12:
			 		m.deleteFaculty();
			 		break;
			 		
			 	case 13:
			 		m.addCourse();
			 		break;
			 		
			 	case 14:
			 		m.viewCourse();
			 		break;
			 	
			 	case 15:
			 		m.updateCourse();
			 		break;
			 		
			 	case 16:
			 		m.deleteCourse();
			 		break;
			 		
			 	case 17:
			 		System.out.println("Thank you!!");
					System.exit(0);	
					
				default:
					System.out.println("Invalid selection");
			 		
			 }
		}
	}
}
