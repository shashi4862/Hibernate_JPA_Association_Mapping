package manyToOneBi_Demo;

import java.util.Scanner;

import javax.persistence.*;

public class FindMerchantByProductId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Produch Id:- ");
		int mname = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select p.merchant from Product p where p.id = ?1");
		q.setParameter(1, mname);
		
		Merchant m1 = (Merchant) q.getSingleResult();
		
		if(m1 != null) {
			System.out.println(m1);
		}
		else {
			System.out.println("No Merchant Found...!!");
		}
	}
}
