package manyToOneBi_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductByMerchantGST_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Merchant GST_Number:- ");
		String mgst = sc.next();
		
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select p from Product p where p.merchant.gst_number = ?1");
		q.setParameter(1, mgst);		
		
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
