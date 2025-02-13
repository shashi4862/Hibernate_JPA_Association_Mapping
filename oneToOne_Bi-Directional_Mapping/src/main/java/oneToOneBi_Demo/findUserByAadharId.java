package oneToOneBi_Demo;
import java.util.Scanner;
import javax.persistence.*;
public class findUserByAadharId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Aadhar Id:- ");
		int Aid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
//		Query q = man.createQuery("select a.user from AadharCard a where a.id=?1");
		Query q = man.createQuery("select u from User u where u.card.id=?1");
		q.setParameter(1, Aid);
		
		try {
			User u = (User)q.getSingleResult();
			System.out.println(u);
		} catch (Exception e) {
			System.err.println("No User Found...");
		}
		
	}
}
