package oneToOneBi_Demo;
import java.util.Scanner;
import javax.persistence.*;
public class findUserByAadharNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Aadhar Number:- ");
		long Aadnum = sc.nextLong();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select u from User u where u.card.number=?1");
		q.setParameter(1, Aadnum);
		try {
			User u = (User)q.getSingleResult();
			System.out.println(u);
		} catch (Exception e) {
			System.err.println("No User Found...");
		}
	}
}
