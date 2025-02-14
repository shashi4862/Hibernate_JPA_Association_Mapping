package org.jsp.OneToManyUni_demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findDepartmentByLocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Department Location:- ");
		String dloc = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select d from Department d  where d.location = ?1");
		q.setParameter(1, dloc);
		
		try {
			Department d1 = (Department)q.getSingleResult();
			System.out.println(d1);
		} catch (Exception e) {
			System.err.println("No department found with this location...");
		}
	}
}
