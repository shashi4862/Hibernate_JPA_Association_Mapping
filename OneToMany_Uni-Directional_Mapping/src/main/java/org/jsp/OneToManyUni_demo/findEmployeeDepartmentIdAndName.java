package org.jsp.OneToManyUni_demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findEmployeeDepartmentIdAndName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter the Employee Name:- ");
//		String ename = sc.next();
		System.out.print("Enter the Department Id:- ");
		int did = sc.nextInt();
		System.out.print("Enter the Department Name:- ");
		String dnm = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
//		Query q = man.createQuery("select d.id, d.name from Department d where d.lemps.name = ?1");
		Query q = man.createQuery("select d.lemps from Department d where d.id = ?1 and d.name = ?2");
		q.setParameter(1, did);
		q.setParameter(2, dnm);
		
		List<Employee> l1 = q.getResultList();
		if(l1.size() > 0) {
			for (Employee emp : l1) {
				System.out.println(emp);
			}
		}
		else {
			System.err.println("No Employee found...");
		}
	}
}
