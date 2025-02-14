package org.jsp.OneToManyUni_demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findEmployeeByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Employee Name:- ");
		String enm = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select e from Employee e  where e.name = ?1");
		q.setParameter(1, enm);
		
		try {
			Employee e1 = (Employee)q.getSingleResult();
			System.out.println(e1);
		} catch (Exception e) {
			System.err.println("No department found with this location...");
		}
	}
}
