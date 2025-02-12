package oneToOneUni_Demo;
import java.util.Scanner;

import javax.persistence.*;
public class findPanCardByNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Id:- ");
		String pnum = sc.next();
		sc.close();
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select p from panCard p where p.number = ?1");
		q.setParameter(1, pnum);
		try {
			panCard p = (panCard)q.getSingleResult();
			System.out.println(p);
		} catch (Exception e) {
			System.err.println("No panCard info found with this number...");
		}
	}
}
