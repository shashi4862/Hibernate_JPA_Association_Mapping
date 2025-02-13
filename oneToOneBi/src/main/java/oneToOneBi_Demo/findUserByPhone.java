package oneToOneBi_Demo;
import java.util.Scanner;
import javax.persistence.*;
public class findUserByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the User Phone:- ");
		long ph = sc.nextLong();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select u from User u where u.phone=?1");
		q.setParameter(1, ph);
		
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		} catch (Exception e) {
			System.err.println("No User found...");
		}
		
	}
}
