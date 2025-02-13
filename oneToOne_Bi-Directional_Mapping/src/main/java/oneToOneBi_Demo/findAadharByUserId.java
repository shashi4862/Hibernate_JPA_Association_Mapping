package oneToOneBi_Demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findAadharByUserId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the User ID:- ");
		int uid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select a from AadharCard a where a.user.id=?1");
		q.setParameter(1, uid);
		
		try {
			AadharCard a = (AadharCard)q.getSingleResult();
			System.out.println(a);
		} catch (Exception e) {
			System.err.println("No Aadhar Card found with this id...");
		}
	}
}
