package oneToOneUni_Demo;
import java.util.Scanner;

import javax.persistence.*;
public class findPersonByPanCardNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Id:- ");
		String pnum = sc.next();
		sc.close();
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select p from person p where p.card.number = ?1");
		q.setParameter(1, pnum);
		
		try {
			person p = (person)q.getSingleResult();
			System.out.println(p);
		} catch (Exception e) {
			System.err.println("No Record found with this panCard number...");
		}
	}
}
