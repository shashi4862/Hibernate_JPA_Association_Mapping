package org.jsp.OneToManyUni_demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class findEmployeeById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Employee Id:- ");
		int eid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Employee e = man.find(Employee.class, eid);
		if(e != null) {			
			System.out.println(e);
		}
		else {
			System.err.println("No Employee found...");
		}
	}
}
