package com.cg.jpastart.entities;

import java.util.Scanner;

import com.cg.jpastart.service.CRUDService;
import com.cg.jpastart.service.CRUDServiceImpl;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner sc = new Scanner(System.in);
		CRUDService services = new CRUDServiceImpl();
		do {
			System.out.println("1-Add Author");
			System.out.println("2-Delete Author");
			System.out.println("3-Edit Author");
			System.out.println("4-Exit");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1: System.out.println("Give Author details below");
					System.out.println("Enter First Name,Middle Name,Last Name,Phone Number");
					Author author = new Author();
					author.setFirstName(sc.next());
					author.setMiddleName(sc.next());
					author.setLastName(sc.next());
					author.setPhoneNo(sc.next());
					services.add(author);
					break;
			case 2: System.out.println("Enter Author Id to delete");
					services.delete(sc.nextInt());
					break;
			case 3: System.out.println("Give Author details to update");
					System.out.println("Enter Author Id,First Name,Middle Name,Last Name,Phone Number");
					author = new Author();
					author.setAuthorId(sc.nextInt());
					author.setFirstName(sc.next());
					author.setMiddleName(sc.next());
					author.setLastName(sc.next());
					author.setPhoneNo(sc.next());
					break;
			case 4: System.exit(0);
					break;
			default:System.out.println("Invalid Choice");
			}
		}while(choice!=4);
	}

}
