package manyToOneBi_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantIdAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Merchant Id:- ");
		int mid = sc.nextInt();
		System.out.print("Enter the Merchant Password:- ");
		String mpsw = sc.next();
		
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select p from Product p where p.merchant.id = ?1 and p.merchant.password = ?2");
		q.setParameter(1, mid);
		q.setParameter(2, mpsw);		
		
		List<Product> l1 = q.getResultList();
		
		if(l1.size() > 0) {
			for (Product product : l1) {				
				System.out.println(product);
			}
		}
		else {
			System.out.println("No Merchant Found...!!");
		}
	}
}
