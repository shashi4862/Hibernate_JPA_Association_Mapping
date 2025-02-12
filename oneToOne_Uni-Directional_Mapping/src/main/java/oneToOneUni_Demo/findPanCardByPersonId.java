package oneToOneUni_Demo;
import java.util.Scanner;
import javax.persistence.*;
public class findPanCardByPersonId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Person Id:- ");
		int pid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select p.card from person p where p.id = ?1");
		q.setParameter(1, pid);
		try {
			panCard card = (panCard) q.getSingleResult();
			System.out.println(card);
		} catch (Exception e) {
			System.err.println("NO Person Info Found...");
		} 
	}
}
