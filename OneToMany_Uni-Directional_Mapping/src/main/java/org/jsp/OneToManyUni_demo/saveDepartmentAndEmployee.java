package org.jsp.OneToManyUni_demo;
import java.util.Arrays;

import javax.persistence.*;
public class saveDepartmentAndEmployee 
{
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		
		Department d = new Department();
		d.setName("Trainer");
		d.setLocation("Bengaluru");
		
		Employee e1 = new Employee();
		e1.setName("Saurav");
		e1.setDesg("Trainer");
		e1.setSalary(40000);
		
		Employee e2 = new Employee();
		e2.setName("Shashi");
		e2.setDesg("Trainer");
		e2.setSalary(45000);
		
		Employee e3 = new Employee();
		e3.setName("Faizal");
		e3.setDesg("Trainer");
		e3.setSalary(30000);
		
		d.setLemps(Arrays.asList(e1, e2, e3));
		man.persist(d);
		tran.commit();
		
	}
}
