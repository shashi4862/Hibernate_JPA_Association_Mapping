package org.jsp.OneToManyUni_demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findDepartmentByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Department Name:- ");
		String dnm = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select d from Department d  where d.name = ?1");
		q.setParameter(1, dnm);
		
		List<Department> l1 = q.getResultList();
		if(l1.size()>0) {
			for (Department dept : l1) {				
				System.out.println(dept);
			}
		}
		else{
			System.err.println("No Department found with this name...");
		}
	}
}
