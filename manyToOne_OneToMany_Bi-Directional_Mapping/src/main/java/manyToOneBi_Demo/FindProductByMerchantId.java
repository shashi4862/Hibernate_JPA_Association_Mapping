package manyToOneBi_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindProductByMerchantId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Merchant Id:- ");
		int mname = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select p from Product p where p.merchant.id = ?1");
		q.setParameter(1, mname);
		
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
