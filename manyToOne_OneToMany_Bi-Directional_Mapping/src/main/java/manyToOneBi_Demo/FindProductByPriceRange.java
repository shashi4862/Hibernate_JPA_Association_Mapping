package manyToOneBi_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByPriceRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Product price range 1:- ");
		String mp1 = sc.next();
		System.out.print("Enter the Product price range 2:- ");
		String mp2 = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
//		Price Attribute is not in the table.
		Query q = man.createQuery("select p from Product p where p.price between ?1 and ?2");
		q.setParameter(1, mp1);
		q.setParameter(1, mp2);
		List<Product> l1= q.getResultList();
		
		if(l1.size() > 0) {
			for (Product product : l1) 
			System.out.println(product);
		}
		else {
			System.out.println("No Merchant Found...!!");
		}
	}
}
