package org.jsp.OneToManyUni_demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class findEmployeeByDepartmentId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Department Id:- ");
		int did = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select d.lemps from Department d  where d.id = ?1");
		q.setParameter(1, did);
		
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
