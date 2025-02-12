package oneToOneUni_Demo;
import java.util.Scanner;

import javax.persistence.*;
public class findPersonByPanCardId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Id:- ");
		int pid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select p from person p where p.card.id = ?1");
		q.setParameter(1, pid);
		
		try {
			person p = (person)q.getSingleResult();
			System.out.println(p);
		} catch (Exception e) {
			System.err.println("NO person found with this panCard Id...");
		}
	}
}
