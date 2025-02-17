package manyToOneBi_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindMerchantByName {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Merchant name:- ");
		String mname = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select m from Merchant m where m.name = ?1");
		q.setParameter(1, mname);
		
		List<Merchant> l1 = q.getResultList();
		if(l1.size() > 0) {
			for (Merchant merchant : l1) {
				System.out.println(merchant);				
			}
		}
		else {
			System.out.println("No Merchant found...!!");
		}
	}
}
