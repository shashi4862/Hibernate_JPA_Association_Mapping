package manyToOneBi_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindProductByMerchantPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Merchant Phone:- ");
		long mphone = sc.nextLong();
		System.out.print("Enter the Merchant Password:- ");
		String mpsw = sc.next();
		
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select p from Product p where p.merchant.phone = ?1 and p.merchant.password = ?2");
		q.setParameter(1, mphone);
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
