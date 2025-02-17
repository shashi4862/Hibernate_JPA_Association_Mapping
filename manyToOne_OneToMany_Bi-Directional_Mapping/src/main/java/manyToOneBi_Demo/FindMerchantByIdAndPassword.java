package manyToOneBi_Demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByIdAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Merchant ID:- ");
		int mid = sc.nextInt();
		System.out.print("Enter the Merchant Password:- ");
		String mpsw = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select m from Merchant m where m.id = ?1 and m.password = ?2");
		q.setParameter(1, mid);
		q.setParameter(2, mpsw);
		
		Merchant m1 = (Merchant) q.getSingleResult();
		
		if(m1 != null) {
			System.out.println(m1);
		}
		else {
			System.out.println("No Merchant Found...!!");
		}
	}
}
