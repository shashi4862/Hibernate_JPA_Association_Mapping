package org.jsp.OneToManyUni_demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class findDepartmentById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Department Id:- ");
		int did = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Department d = man.find(Department.class, did);
		if(d != null) {
			System.out.println(d);
		}
		else {
			System.err.println("No Department Found...");
		}
	}
}
