package oneToOneBi_Demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findAadharByUserPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the User Phone:- ");
		long aid = sc.nextLong();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select a from AadharCard a where a.user.phone=?1");
		q.setParameter(1, aid);
		
		try {
			AadharCard a = (AadharCard)q.getSingleResult();
			System.out.println(a);
		} catch (Exception e) {
			System.err.println("No User found with this Phone...");
		}
	}
}
