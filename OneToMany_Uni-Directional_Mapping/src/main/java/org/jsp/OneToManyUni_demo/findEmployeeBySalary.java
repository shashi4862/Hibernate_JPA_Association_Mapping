package org.jsp.OneToManyUni_demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findEmployeeBySalary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Employee Salary:- ");
		double dsal = sc.nextDouble();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select e from Employee e where e.salary = ?1");
		q.setParameter(1, dsal);
		
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
