package oneToOneUni_Demo;
import java.util.Scanner;
import javax.persistence.*;
public class findPersonByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Phone Number:- ");
		long ph = sc.nextLong();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select p from person p where p.phone = ?1");
		q.setParameter(1, ph);
		try {
			person p = (person) q.getSingleResult();
			System.out.println(p);
		} catch (Exception e) {
			System.err.println("NO Person Info found...");
		} 
	}
}
